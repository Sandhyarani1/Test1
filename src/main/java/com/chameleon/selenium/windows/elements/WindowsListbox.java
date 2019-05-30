package com.chameleon.selenium.windows.elements;

import static com.chameleon.utils.TestReporter.interfaceLog;
import static com.chameleon.utils.TestReporter.logTrace;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Quotes;

import com.chameleon.selenium.elements.Element;
import com.chameleon.selenium.elements.Listbox;
import com.chameleon.selenium.exceptions.OptionNotInListboxException;
import com.chameleon.selenium.windows.ExtendedWindowsDriver;

/**
 * Wrapper around a WebElement for the Select class in Selenium.
 */
public class WindowsListbox extends Listbox {
    /**
     * Wraps a WebElement with listbox functionality.
     *
     * @param extendedElement
     *            - element to wrap up
     */

    public WindowsListbox(ExtendedWindowsDriver driver, By by) {
        super(driver, by);

        logTrace("Entering Listbox#init");

        if (extendedElement != null) {
            optionTag = determineOptionTag();
            multiple = isMultiple();
        }

        logTrace("Exiting Listbox#init");
    }

    public WindowsListbox(ExtendedWindowsDriver driver, By by, org.openqa.selenium.WebElement element) {
        super(driver, by, element);
    }

    @Override
    public void select(String text) {
        logTrace("Entering WindowsListbox#select");

        if (isNotBlank(text)) {
            // In the case when the Listbox was created, but element was not found, then optionTag is not set
            // Ensure optionTag is set
            if (isBlank(optionTag)) {
                logTrace("Tag was empty or null. Determine tag");
                optionTag = determineOptionTag();
            }

            // Use normalize-space on the element itself (.) to limit text search to just the element
            // Using text() would get all text in child elements as well
            logTrace("Finding child elements in Listbox");
            List<org.openqa.selenium.WebElement> elements = getWrappedElement().findElements(By.xpath(".//" + optionTag + "[@Name = " + Quotes.escape(text) + "]"));
            List<Element> options = new ArrayList<>();
            elements.forEach(option -> options.add(new Element(driver, by, option)));

            // If no options found for requested text, collect all option values and report out
            if (options.isEmpty()) {
                String optionList = getOptionTextValues().stream().collect(Collectors.joining(" | "));

                interfaceLog(" The value of <b>[ " + text + "</b> ] was not found in Listbox [  <b>"
                        + getElementLocatorInfo() + " </b>]. Acceptable values are " + optionList + " ]");
                logTrace("Exiting Listbox#select");
                throw new OptionNotInListboxException("The value of [ " + text + " ] was not found in Listbox [  "
                        + getElementLocatorInfo() + " ]. Acceptable values are " + optionList, driver);
            }
            logTrace("Successfully found child elements");

            // for each matching element, set to true
            logTrace("Selecting all matching options");
            for (Element option : options) {
                setSelected(option, true);
                if (!isMultiple()) {
                    logTrace("Listbox is not multiple, only selected first option");
                    return;
                }
            }

        } else {
            interfaceLog("Skipping selection of option in Listbox [ <b>" + getElementLocatorInfo() + " </b> ]");
        }

        logTrace("Exiting WindowsListbox#select");
    }

    @Override
    protected String determineOptionTag() {
        logTrace("Entering WindowsListbox#determineOptionTag");
        String tagName = getWrappedElement().getTagName();

        switch (tagName.toLowerCase()) {
            case "controltype.list":
            case "list":
                logTrace("Determined option tag for [ " + tagName + " ] to be [ ListItem ]");
                logTrace("Exiting WindowsListbox#determineOptionTag");
                return "ListItem";
            case "controltype.combobox":
            default:
                logTrace("Determined option tag for [ " + tagName + " ] to be [ Text ]");
                logTrace("Exiting WindowsListbox#determineOptionTag");
                return "Text";

        }
    }

}