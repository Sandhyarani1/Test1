package com.chameleon.selenium.mobile;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.chameleon.selenium.ExtendedDriver;
import com.chameleon.selenium.elements.Button;
import com.chameleon.selenium.elements.Checkbox;
import com.chameleon.selenium.elements.Label;
import com.chameleon.selenium.elements.Link;
import com.chameleon.selenium.elements.Listbox;
import com.chameleon.selenium.elements.RadioGroup;
import com.chameleon.selenium.elements.Table;
import com.chameleon.selenium.elements.Textbox;
import com.chameleon.selenium.mobile.elements.MobileButton;
import com.chameleon.selenium.mobile.elements.MobileCheckbox;
import com.chameleon.selenium.mobile.elements.MobileElement;
import com.chameleon.selenium.mobile.elements.MobileLabel;
import com.chameleon.selenium.mobile.elements.MobileLink;
import com.chameleon.selenium.mobile.elements.MobileListbox;
import com.chameleon.selenium.mobile.elements.MobileRadioGroup;
import com.chameleon.selenium.mobile.elements.MobileTable;
import com.chameleon.selenium.mobile.elements.MobileTextbox;

@SuppressWarnings("unchecked")
public class ExtendedMobileDriver extends ExtendedDriver {
    private int currentScriptTimeout;

    /**
     * Method to navigate to a user-defined URL
     * Example usage: getDriver().get(url);
     *
     * @param url
     *            - URL to which to navigate
     * @see http://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/WebDriver.html#get-java.lang.String-
     */
    @Override
    public void get(String url) {
        driver.get(url);
    }

    /**
     * Method to return the current URL
     * Example usage: getDriver().getCurrentUrl();
     *
     * @return - current URL
     * @see http://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/WebDriver.html#getCurrentUrl--
     */
    @Override
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Method to set the script timeout
     *
     * @param timeout
     *            - timeout with which to set the script timeout
     * @see http://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/WebDriver.Timeouts.html#setScriptTimeout-long-java.util.concurrent.TimeUnit-
     */
    public void setScriptTimeout(int timeout) {
        setScriptTimeout(timeout, TimeUnit.SECONDS);
    }

    /**
     * Method to set the script timeout
     *
     * @param timeout
     *            - timeout with which to set the script timeout
     * @param timeUnit
     *            -Java TimeUnit, used to determine the unit of time to be associated with the timeout
     * @see http://docs.oracle.com/javase/8/docs/api/java/util/concurrent/TimeUnit.html
     * @see http://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/WebDriver.Timeouts.html#setScriptTimeout-long-java.util.concurrent.TimeUnit-
     */
    public void setScriptTimeout(int timeout, TimeUnit timeUnit) {
        this.currentScriptTimeout = timeout;
        driver.manage().timeouts().setScriptTimeout(timeout, timeUnit);
    }

    /**
     * Method to return the script timeout
     *
     * @return - script timeout
     */
    public int getScriptTimeout() {
        return currentScriptTimeout;
    }

    /**
     * Method to find all WebElements for a given page, using a Selenium <b><i>By</i></b> locator
     *
     * @param by
     *            - Selenium <b><i>By</i></b> locator with which to locate WebElements
     * @return - List of WebElements, if any, found by using the Selenium <b><i>By</i></b> locator
     * @see http://docs.oracle.com/javase/8/docs/api/java/util/List.html
     * @see http://selenium.googlecode.com/svn/trunk/docs/api/java/org/openqa/selenium/By.html
     * @see http://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/WebDriver.html#findElements-org.openqa.selenium.By-
     */
    public <T extends MobileElement> List<T> findMobileElements(By by) {

        List<org.openqa.selenium.WebElement> elements = driver.findElements(by);
        List<MobileElement> el = new ArrayList<>();
        elements.forEach(element -> el.add(new MobileElement(this, by, element)));
        return (List<T>) el;
    }

    /**
     * Method to find a single Element for a given page, using a Selenium <b><i>By</i></b> locator
     *
     * @param by
     *            - Selenium <b><i>By</i></b> locator with which to locate the Element
     * @return Element, if any, found by using the Selenium <b><i>By</i></b> locator
     * @see http://selenium.googlecode.com/svn/trunk/docs/api/java/org/openqa/selenium/By.html
     * @see http://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/WebDriver.html#findElement-org.openqa.selenium.By-
     * @see http://github.com/Orasi/Chameleon/blob/master/src/main/java/com/orasi/web/webelements/impl/ElementImpl.java
     */
    public <T extends org.openqa.selenium.WebElement> T findWebElement(By by) {
        return driver.findElement(by);
    }

    /**
     * Method to find all WebElements for a given page, using a Selenium <b><i>By</i></b> locator
     *
     * @param by
     *            - Selenium <b><i>By</i></b> locator with which to locate WebElements
     * @return - List of WebElements, if any, found by using the Selenium <b><i>By</i></b> locator
     * @see http://docs.oracle.com/javase/8/docs/api/java/util/List.html
     * @see http://selenium.googlecode.com/svn/trunk/docs/api/java/org/openqa/selenium/By.html
     * @see http://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/WebDriver.html#findElements-org.openqa.selenium.By-
     */
    @Override
    public <T extends org.openqa.selenium.WebElement> List<T> findElements(By by) {
        return driver.findElements(by);
    }

    /**
     * Method to find a single Textbox for a given page, using a Selenium <b><i>By</i></b> locator
     *
     * @param by
     *            - Selenium <b><i>By</i></b> locator with which to locate the Textbox
     * @return Textbox, if any, found by using the Selenium <b><i>By</i></b> locator
     * @see http://selenium.googlecode.com/svn/trunk/docs/api/java/org/openqa/selenium/By.html
     * @see http://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/WebDriver.html#findElement-org.openqa.selenium.By-
     * @see http://github.com/Orasi/Chameleon/blob/master/src/main/java/com/orasi/web/webelements/impl/TextboxImpl.java
     */
    @Override
    public <T extends Textbox> T findTextbox(By by) {
        return (T) new MobileTextbox(this, by);
    }

    /**
     * Method to find a single Textbox for a given page, using a Selenium <b><i>By</i></b> locator
     *
     * @param by
     *            - Selenium <b><i>By</i></b> locator with which to locate the Textbox
     * @return Textbox, if any, found by using the Selenium <b><i>By</i></b> locator
     * @see http://selenium.googlecode.com/svn/trunk/docs/api/java/org/openqa/selenium/By.html
     * @see http://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/WebDriver.html#findElement-org.openqa.selenium.By-
     * @see http://github.com/Orasi/Chameleon/blob/master/src/main/java/com/orasi/web/webelements/impl/TextboxImpl.java
     */
    @Override
    public <T extends Textbox> List<T> findTextboxes(By by) {
        List<org.openqa.selenium.WebElement> elements = findElements(by);
        List<MobileTextbox> textboxes = new ArrayList<>();
        elements.forEach(element -> textboxes.add(new MobileTextbox(this, by, element)));
        return (List<T>) textboxes;
    }

    /**
     * Method to find a single Button for a given page, using a Selenium <b><i>By</i></b> locator
     *
     * @param by
     *            - Selenium <b><i>By</i></b> locator with which to locate the Button
     * @return Button, if any, found by using the Selenium <b><i>By</i></b> locator
     * @see http://selenium.googlecode.com/svn/trunk/docs/api/java/org/openqa/selenium/By.html
     * @see http://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/WebDriver.html#findElement-org.openqa.selenium.By-
     * @see http://github.com/Orasi/Chameleon/blob/master/src/main/java/com/orasi/web/webelements/impl/ButtonImpl.java
     */
    @Override
    public <T extends Button> T findButton(By by) {
        return (T) new MobileButton(this, by);
    }

    /**
     * Method to find Buttons for a given page, using a Selenium <b><i>By</i></b> locator
     *
     * @param by
     *            - Selenium <b><i>By</i></b> locator with which to locate the Buttons
     * @return Button, if any, found by using the Selenium <b><i>By</i></b> locator
     * @see http://selenium.googlecode.com/svn/trunk/docs/api/java/org/openqa/selenium/By.html
     * @see http://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/WebDriver.html#findElement-org.openqa.selenium.By-
     * @see http://github.com/Orasi/Chameleon/blob/master/src/main/java/com/orasi/web/webelements/impl/ButtonImpl.java
     */
    @Override
    public <T extends Button> List<T> findButtons(By by) {
        List<org.openqa.selenium.WebElement> elements = findElements(by);
        List<MobileButton> buttons = new ArrayList<>();
        elements.forEach(element -> buttons.add(new MobileButton(this, by, element)));
        return (List<T>) buttons;
    }

    /**
     * Method to find a single Checkbox for a given page, using a Selenium <b><i>By</i></b> locator
     *
     * @param by
     *            - Selenium <b><i>By</i></b> locator with which to locate the Checkbox
     * @return Checkbox, if any, found by using the Selenium <b><i>By</i></b> locator
     * @see http://selenium.googlecode.com/svn/trunk/docs/api/java/org/openqa/selenium/By.html
     * @see http://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/WebDriver.html#findElement-org.openqa.selenium.By-
     * @see http://github.com/Orasi/Chameleon/blob/master/src/main/java/com/orasi/web/webelements/impl/CheckboxImpl.java
     */
    @Override
    public <T extends Checkbox> T findCheckbox(By by) {
        return (T) new MobileCheckbox(this, by);
    }

    @Override
    public <T extends Checkbox> List<T> findCheckboxes(By by) {
        List<org.openqa.selenium.WebElement> elements = findElements(by);
        List<MobileCheckbox> checkboxes = new ArrayList<>();
        elements.forEach(element -> checkboxes.add(new MobileCheckbox(this, by, element)));
        return (List<T>) checkboxes;
    }

    /**
     * Method to find a single Label for a given page, using a Selenium <b><i>By</i></b> locator
     *
     * @param by
     *            - Selenium <b><i>By</i></b> locator with which to locate the Checkbox
     * @return Label, if any, found by using the Selenium <b><i>By</i></b> locator
     * @see http://selenium.googlecode.com/svn/trunk/docs/api/java/org/openqa/selenium/By.html
     * @see http://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/WebDriver.html#findElement-org.openqa.selenium.By-
     * @see http://github.com/Orasi/Chameleon/blob/master/src/main/java/com/orasi/web/webelements/impl/LabelImpl.java
     */
    @Override
    public <T extends Label> T findLabel(By by) {
        return (T) new MobileLabel(this, by);
    }

    @Override
    public <T extends Label> List<T> findLabels(By by) {
        List<org.openqa.selenium.WebElement> elements = findElements(by);
        List<MobileLabel> labels = new ArrayList<>();
        elements.forEach(element -> labels.add(new MobileLabel(this, by, element)));
        return (List<T>) labels;
    }

    /**
     * Method to find a single Link for a given page, using a Selenium <b><i>By</i></b> locator
     *
     * @param by
     *            - Selenium <b><i>By</i></b> locator with which to locate the Link
     * @return Link, if any, found by using the Selenium <b><i>By</i></b> locator
     * @see http://selenium.googlecode.com/svn/trunk/docs/api/java/org/openqa/selenium/By.html
     * @see http://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/WebDriver.html#findElement-org.openqa.selenium.By-
     * @see http://github.com/Orasi/Chameleon/blob/master/src/main/java/com/orasi/web/webelements/impl/LinkImpl.java
     */
    @Override
    public <T extends Link> T findLink(By by) {
        return (T) new MobileLink(this, by);
    }

    @Override
    public <T extends Link> List<T> findLinks(By by) {
        List<org.openqa.selenium.WebElement> elements = findElements(by);
        List<MobileLink> links = new ArrayList<>();
        elements.forEach(element -> links.add(new MobileLink(this, by, element)));
        return (List<T>) links;
    }

    /**
     * Method to find a single Listbox for a given page, using a Selenium <b><i>By</i></b> locator
     *
     * @param by
     *            - Selenium <b><i>By</i></b> locator with which to locate the Listbox
     * @return Listbox, if any, found by using the Selenium <b><i>By</i></b> locator
     * @see http://selenium.googlecode.com/svn/trunk/docs/api/java/org/openqa/selenium/By.html
     * @see http://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/WebDriver.html#findElement-org.openqa.selenium.By-
     * @see http://github.com/Orasi/Chameleon/blob/master/src/main/java/com/orasi/web/webelements/impl/ListboxImpl.java
     */
    @Override
    public <T extends Listbox> T findListbox(By by) {
        return (T) new MobileListbox(this, by);
    }

    @Override
    public <T extends Listbox> List<T> findListboxes(By by) {
        List<org.openqa.selenium.WebElement> elements = findElements(by);
        List<MobileListbox> lists = new ArrayList<>();
        elements.forEach(element -> lists.add(new MobileListbox(this, by, element)));
        return (List<T>) lists;
    }

    /**
     * Method to find a single RadioGroup for a given page, using a Selenium <b><i>By</i></b> locator
     *
     * @param by
     *            - Selenium <b><i>By</i></b> locator with which to locate the RadioGroup
     * @return RadioGroup, if any, found by using the Selenium <b><i>By</i></b> locator
     * @see http://selenium.googlecode.com/svn/trunk/docs/api/java/org/openqa/selenium/By.html
     * @see http://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/WebDriver.html#findElement-org.openqa.selenium.By-
     * @see http://github.com/Orasi/Chameleon/blob/master/src/main/java/com/orasi/web/webelements/impl/RadioGroupImpl.java
     */
    @Override
    public <T extends RadioGroup> T findRadioGroup(By by) {
        return (T) new MobileRadioGroup(this, by);
    }

    /**
     * Method to find a single MobileTable for a given page, using a Selenium <b><i>By</i></b> locator
     *
     * @param by
     *            - Selenium <b><i>By</i></b> locator with which to locate the MobileTable
     * @return MobileTable, if any, found by using the Selenium <b><i>By</i></b> locator
     * @see http://selenium.googlecode.com/svn/trunk/docs/api/java/org/openqa/selenium/By.html
     * @see http://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/WebDriver.html#findElement-org.openqa.selenium.By-
     * @see http://github.com/Orasi/Chameleon/blob/master/src/main/java/com/orasi/web/webelements/impl/MobileTableImpl.java
     */
    @Override
    public <T extends Table> T findTable(By by) {
        return (T) new MobileTable(this, by);
    }

    @Override
    public <T extends Table> List<T> findTables(By by) {
        List<org.openqa.selenium.WebElement> elements = findElements(by);
        List<MobileTable> tables = new ArrayList<>();
        elements.forEach(element -> tables.add(new MobileTable(this, by, element)));
        return (List<T>) tables;
    }

    /**
     * Method to find a single WebElement for a given page, using a Selenium <b><i>By</i></b> locator
     *
     * @param by
     *            - Selenium <b><i>By</i></b> locator with which to locate the WebElement
     * @return WebElement, if any, found by using the Orasi <b><i>ByNG</i></b> locator
     * @see http://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/WebDriver.html#findElement-org.openqa.selenium.By-
     * @see http://selenium.googlecode.com/svn/trunk/docs/api/java/org/openqa/selenium/By.html
     * @see http://selenium.googlecode.com/svn/trunk/docs/api/java/org/openqa/selenium/WebElement.html
     */

    @Override
    public MobileElement findElement(By by) {
        return new MobileElement(this, by);
    }

}
