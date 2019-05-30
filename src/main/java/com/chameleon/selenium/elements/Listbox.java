package com.chameleon.selenium.elements;

import static com.chameleon.utils.TestReporter.interfaceLog;
import static com.chameleon.utils.TestReporter.logTrace;
import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Quotes;

import com.chameleon.selenium.ExtendedDriver;
import com.chameleon.selenium.exceptions.OptionNotInListboxException;
import com.chameleon.selenium.web.WebException;

/**
 * Interface for a select element.
 */

public class Listbox extends Element {
    protected String optionTag = "";
    protected String clickableTag = "";
    protected Boolean multiple;

    /**
     * Wraps a WebElement with listbox functionality.
     *
     * @param extendedElement
     *            - element to wrap up
     */

    public Listbox(ExtendedDriver driver, By by) {
        super(driver, by);

        logTrace("Entering Listbox#init");

        if (extendedElement != null) {
            optionTag = determineOptionTag();
            multiple = isMultiple();
        }

        logTrace("Exiting Listbox#init");
    }

    public Listbox(ExtendedDriver driver, By by, org.openqa.selenium.WebElement element) {
        super(driver, by, element);
    }

    /**
     * Allows user to override the default element tag of the container for Listbox items. By default,
     * Listbox will attempt to find child "li" elements for a parent "ul" Listbox. "select" and "datalist"
     * type Listboxes will attempt to find child "option" elements. Anything other than "li" or
     * "option" can be defined here
     *
     * @param tag
     *            - tag of the child element to search
     */

    public void overrideOptionTag(String tag) {
        logTrace("Entering Listbox#overrideOptionTag");
        if (isBlank(tag)) {
            throw new WebException("Option tag cannot be null or empty", driver);
        }
        optionTag = tag.trim();
        interfaceLog("Overriding Listbox option tag to be [ " + tag + " ]");
        logTrace("Exiting Listbox#overrideOptionTag");
    }

    /**
     * Allows user to override the default element tag to click in the container for Listbox items in the
     * case the element with the serached value does not contain the click event. By default,
     * Listbox will attempt to click child "li" elements for a parent "ul" Listbox. "select" and "datalist"
     * type Listboxes will attempt to click child "option" elements. Anything other than "li" or
     * "option" can be defined here
     *
     * @param tag
     *            - tag of the child element to click
     */

    public void overrideClickableTag(String tag) {
        logTrace("Entering Listbox#overrideClickableTag");
        if (isBlank(tag)) {
            throw new WebException("Clickable tag cannot be null or empty", driver);
        }
        clickableTag = tag.trim();
        interfaceLog("Overriding Listbox element to click tag to be [ " + clickableTag + " ]");
        logTrace("Exiting Listbox#overrideClickableTag");
    }

    /**
     * Click option with text
     *
     * @param text
     *            - visible text to select
     */

    public void select(String text) {
        logTrace("Entering Listbox#select");

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
            List<org.openqa.selenium.WebElement> elements = getWrappedElement().findElements(By.xpath(
                    ".//" + optionTag + "[normalize-space(.) = " + Quotes.escape(text) + "]"));
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

        logTrace("Exiting Listbox#select");
    }

    /**
     * Click option with attribute with specific value
     *
     * @param text
     *            - value option to select
     */

    public void selectValue(String value) {
        logTrace("Entering Listbox#selectValue");
        if (isNotBlank(value)) {

            // In the case when the Listbox was created, but element was not found, then optionTag is not set
            // Ensure optionTag is set
            if (isBlank(optionTag)) {
                logTrace("Tag was empty or null. Determine tag");
                optionTag = determineOptionTag();
            }

            logTrace("Finding child elements in Listbox");
            List<org.openqa.selenium.WebElement> elements = getWrappedElement().findElements(By.xpath(
                    ".//" + optionTag + "[@value = " + Quotes.escape(value) + "]"));
            List<Element> options = new ArrayList<>();
            elements.forEach(option -> options.add(new Element(driver, by, option)));

            // If no options found for requested value, collect all option values and report out
            if (options.isEmpty()) {
                String optionList = getOptionValues().stream().collect(Collectors.joining(" | "));

                interfaceLog(" The value of <b>[ " + value + "</b> ] was not found in Listbox [  <b>"
                        + getElementLocatorInfo() + " </b>]. Acceptable values are " + optionList + " ]");
                logTrace("Exiting Listbox#selectValue");
                throw new OptionNotInListboxException("The value of [ " + value + " ] was not found in Listbox [  "
                        + getElementLocatorInfo() + " ]. Acceptable values are " + optionList, driver);
            }

            logTrace("Successfully found child elements");

            // for each matching element, set to true
            for (Element option : options) {
                setSelected(option, true);
                if (!isMultiple()) {
                    logTrace("Listbox is not multiple, only selected first option");
                    return;
                }
            }

        } else {
            interfaceLog("Skipping input to Textbox [ <b>" + getElementLocatorInfo() + " </b> ]");
        }
        logTrace("Exiting Listbox#selectValue");
    }

    /**
     * Deselect all selection options only if multi-select Listbox
     */

    public void deselectAll() {
        logTrace("Entering Listbox#deselectAll");
        if (!isMultiple()) {
            throw new WebException("You may only deselect all options of a multi-select");
        }

        logTrace("Deselecting all options");
        for (Element option : getOptions()) {
            setSelected(option, false);
        }
        logTrace("Exiting Listbox#deselectAll");
    }

    /**
     * Click option with text
     *
     * @param text
     *            - visible text to select
     */

    public void deselectByVisibleText(String text) {
        logTrace("Entering Listbox#deselectByVisibleText");
        if (!isMultiple()) {
            throw new WebException("You may only deselect options of a multi-select");
        }

        logTrace("Finding child elements in Listbox");
        List<org.openqa.selenium.WebElement> elements = getWrappedElement().findElements(By.xpath(
                ".//" + optionTag + "[normalize-space(.) =" + Quotes.escape(text) + "]"));
        List<Element> options = new ArrayList<>();
        elements.forEach(option -> options.add(new Element(driver, by, option)));

        for (Element option : options) {
            setSelected(option, false);
        }
        logTrace("Exiting Listbox#deselectByVisibleText");
    }

    public List<Element> getAllSelectedOptions() {
        logTrace("Entering Listbox#getAllSelectedOptions");
        List<Element> options = getOptions().stream().filter(Element::isSelected).collect(toList());
        logTrace("Exiting Listbox#getAllSelectedOptions");
        return options;
    }

    /**
     * return first option that is select in list
     *
     * @return first option that is select in list
     */

    public Element getFirstSelectedOption() {
        logTrace("Entering Listbox#getFirstSelectedOption");
        Element option = getOptions().stream().filter(Element::isSelected).findFirst().orElse(null);
        logTrace("Exiting Listbox#getFirstSelectedOption");
        return option;
    }

    /**
     * return list of all options in the select
     *
     * @return list of all options in the select.
     */

    public <T extends Element> List<T> getOptions() {
        logTrace("Entering Listbox#getOptions");
        if (getWrappedElement() != null) {
            optionTag = determineOptionTag();
            multiple = isMultiple();
        }
        List<org.openqa.selenium.WebElement> elements = getWrappedElement().findElements(By.xpath(".//" + optionTag));
        List<Element> options = new ArrayList<>();
        elements.forEach(option -> options.add(new Element(driver, by, option)));
        logTrace("Exiting Listbox#getOptions");
        return (List<T>) options;
    }

    /**
     * list of all option values in the select.
     *
     * @return list of all option values in the select.
     */

    public List<String> getOptionValues() {
        logTrace("Entering Listbox#getOptionValues");
        // Get attribute of value from each option and return in a List
        List<String> values = getOptions().stream().map(e -> e.getAttribute("value")).map(String::trim).collect(toList());
        logTrace("Exiting Listbox#getOptionValues");
        return values;
    }

    /**
     * Wraps Selenium's method.
     *
     * @return list of all option values in the select.
     */

    public List<String> getOptionTextValues() {
        logTrace("Entering Listbox#getOptionTextValues");
        // Get text value from each option and return in a List
        List<String> values = getOptions().stream().map(Element::getText).map(String::trim).collect(toList());
        logTrace("Exiting Listbox#getOptionTextValues");
        return values;
    }

    public boolean isSelected(String option) {
        logTrace("Entering Listbox#isSelected");
        boolean selected = getAllSelectedOptions().stream().anyMatch(selectedOption -> selectedOption.getText().equals(option));
        logTrace("Exiting Listbox#isSelected");
        return selected;
    }

    public boolean isMultiple() {
        logTrace("Entering Listbox#isMultiple");
        if (multiple == null) {
            String value = getWrappedElement().getAttribute("multiple");

            // The atoms normalize the returned value, but check for "false"
            multiple = (value != null && !"false".equals(value));
        }
        logTrace("Exiting Listbox#isMultiple");
        return multiple;
    }

    protected String determineOptionTag() {
        logTrace("Entering Listbox#determineOptionTag");
        String tagName = getWrappedElement().getTagName();

        switch (tagName.toLowerCase()) {
            case "ul":
                logTrace("Determined option tag for [ " + tagName + " ] to be [ li ]");
                logTrace("Exiting Listbox#determineOptionTag");
                return "li";

            case "select":
            case "datalist":
            default:
                logTrace("Determined option tag for [ " + tagName + " ] to be [ option ]");
                logTrace("Exiting Listbox#determineOptionTag");
                return "option";
        }
    }

    /**
     * Select or deselect specified option
     *
     * @param option
     *            The option which state needs to be changed
     * @param select
     *            Indicates whether the option needs to be selected (true) or
     *            deselected (false)
     */
    protected void setSelected(final Element option, boolean select) {
        boolean isSelected = option.isSelected();
        if ((!isSelected && select) || (isSelected && !select)) {
            if (isBlank(clickableTag)) {
                option.click();
            } else {
                Element el = option.findElement(By.xpath(".//" + clickableTag));
                new Element(driver, by, el).click();
            }

        }
    }
}