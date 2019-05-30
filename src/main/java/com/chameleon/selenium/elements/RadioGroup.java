package com.chameleon.selenium.elements;

import static com.chameleon.utils.TestReporter.interfaceLog;
import static com.chameleon.utils.TestReporter.logTrace;

import java.util.Arrays;
import java.util.List;

import javax.naming.directory.NoSuchAttributeException;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.chameleon.selenium.ExtendedDriver;

/**
 * Interface for a select element.
 */
public class RadioGroup extends Element {
    private List<org.openqa.selenium.WebElement> radioButtons = null;
    private int numberOfRadioButtons;
    private int currentIndex;
    private List<String> stringOptions;
    private int numberOfOptions;
    private String selectedOption;

    /**
     * Wraps a WebElement as an Element with radioGroup functionality.
     *
     * @param extendedElement
     *            - element to wrap up
     * @throws NoSuchAttributeException
     */

    public RadioGroup(ExtendedDriver driver, By by) {
        super(driver, by);
        logTrace("Entering RadioGroup#init");
        this.radioButtons = getWrappedElement().findElements(By.tagName("input"));
        if (radioButtons.isEmpty()) {
            radioButtons = driver.findElements(by);
        }
        getNumberOfRadioButtons();
        getAllOptions();
        Assert.assertNotEquals(radioButtons.size(), 0,
                "No radio buttons were found for the element [" + extendedElement + "].");
        currentIndex = getCurrentIndex();
        logTrace("Exiting RadioGroup#init");
    }

    /**
     * @summary - Defines the number of radio buttons in the group by the number
     *          of 'input' tags found in the wrapped object
     */
    protected void setNumberOfRadioButtons() {
        numberOfRadioButtons = radioButtons.size();
    }

    /**
     * @summary - Defines the number of radio buttons and return the integer
     *          count
     */
    //
    protected int getNumberOfRadioButtons() {
        setNumberOfRadioButtons();
        return numberOfRadioButtons;
    }

    /**
     * @summary - Sets the current index for this instance, selects the radio
     *          button by index and sets the selected option for this instance
     */

    public void selectByIndex(int index) {
        logTrace("Entering RadioGroup#selectByIndex");
        currentIndex = index;
        try {
            radioButtons.get(currentIndex).click();
        } catch (RuntimeException rte) {
            interfaceLog("Select option <b> [ " + currentIndex
                    + " ] </b> from the radio group [ <b>" + getElementLocatorInfo() + " </b> ]", true);
            logTrace("Exiting RadioGroup#selectByIndex");
            throw rte;
        }
        interfaceLog("Select option <b> [ " + currentIndex + " ] </b> from the radio group [ <b>"
                + getElementLocatorInfo() + " </b> ]", true);

        setSelectedOption();
        logTrace("Exiting RadioGroup#selectByIndex");
    }

    /**
     * @summary - Defines and returns a List<String> of all options for the
     *          radio group
     */

    public List<String> getAllOptions() {
        logTrace("Entering RadioGroup#getAllOptions");
        stringOptions = Arrays.asList(new String[radioButtons.size()]);
        int loopCounter = 0;

        for (org.openqa.selenium.WebElement option : radioButtons) {
            stringOptions.set(loopCounter, option.getAttribute("value"));
            loopCounter++;
        }

        logTrace("Exiting RadioGroup#getAllOptions");
        return stringOptions;
    }

    /**
     * @summary - Defines a List<String> of all options for this instance as
     *          well as the number of options for the radio group
     */

    protected void setNumberOfOptions() {
        getAllOptions();
        numberOfOptions = stringOptions.size();
    }

    /**
     * @summary - Defines the number of options and return the integer count
     */

    public int getNumberOfOptions() {
        logTrace("Entering RadioGroup#getNumberOfOptions");
        setNumberOfOptions();
        logTrace("Exiting RadioGroup#getNumberOfOptions");
        return numberOfOptions;
    }

    /**
     * @summary - Defines all options for this instance, selects an option by
     *          the string parameter and sets the selected option for this
     *          instance
     */

    public void selectByOption(String option) {
        logTrace("Entering RadioGroup#selectByOption");
        getAllOptions();
        for (int loopCounter = 0; loopCounter < stringOptions.size(); loopCounter++) {
            if (stringOptions.get(loopCounter).trim().equalsIgnoreCase(option.trim())) {
                currentIndex = loopCounter;

                try {
                    new Element(driver, By.xpath("//input[" + (currentIndex + 1) + "]")).click();
                } catch (RuntimeException rte) {
                    interfaceLog("Select option <b> [ " + option
                            + " ] </b> from the radio group [ <b>" + getElementLocatorInfo() + " </b> ]",
                            true);
                    logTrace("Exiting RadioGroup#selectByOption");
                    throw rte;
                }
                interfaceLog("Select option <b> [ " + option
                        + " ] </b> from the radio group [ <b>" + getElementLocatorInfo() + " </b> ]");

                getSelectedOption();
                break;
            }
        }
        setSelectedOption();
        logTrace("Exiting RadioGroup#selectByOption");
    }

    /**
     * @summary - Defines a List<String> of all options for this instance and
     *          defines the currently selected option, if any
     */

    protected void setSelectedOption() {
        getAllOptions();
        selectedOption = stringOptions.get(currentIndex).toString();
    }

    /**
     * @summary - Defines a List<String> of all options for this instance and
     *          defines the currently selected option, if any and returns the
     *          String value of the selected option
     */

    public String getSelectedOption() {
        logTrace("Entering RadioGroup#getSelectedOption");
        setSelectedOption();
        logTrace("Entering RadioGroup#getSelectedOption");
        return this.selectedOption;
    }

    /**
     * @summary - Returns the integer index of the currently selected radio
     *          button
     */

    public int getSelectedIndex() {
        return currentIndex;
    }

    /**
     * @summary - Loops through all radio buttons for one that possesses an
     *          attribute that indicates the button is selected. NOTE: Within
     *          the method, the field "String[] attributes" is a string array
     *          for possible values that could indicate radio button is
     *          selected/checked. This array can be appended with new attributes
     *          that indicate an option is selected/checked.
     */
    protected int getCurrentIndex() {
        String[] attributes = { "checked" };
        int loopCounter = 0;
        int attributeLoopCounter = 0;
        int index = -1;
        String checked = null;

        for (loopCounter = 0; loopCounter < numberOfRadioButtons; loopCounter++) {
            for (attributeLoopCounter = 0; attributeLoopCounter < attributes.length; attributeLoopCounter++) {
                if (!(radioButtons.get(loopCounter).getAttribute(attributes[attributeLoopCounter]) == null)) {
                    checked = radioButtons.get(loopCounter).getAttribute(attributes[attributeLoopCounter]);
                    if (checked.equalsIgnoreCase("true")) {
                        index = loopCounter;
                        break;

                    }
                }
            }
            if (checked != null) {
                break;
            }
        }
        return index;
    }
}