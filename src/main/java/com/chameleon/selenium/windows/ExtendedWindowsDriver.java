package com.chameleon.selenium.windows;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.chameleon.selenium.ExtendedDriver;
import com.chameleon.selenium.elements.Button;
import com.chameleon.selenium.elements.Checkbox;
import com.chameleon.selenium.elements.Label;
import com.chameleon.selenium.elements.Link;
import com.chameleon.selenium.elements.Listbox;
import com.chameleon.selenium.elements.RadioGroup;
import com.chameleon.selenium.elements.Table;
import com.chameleon.selenium.elements.Textbox;
import com.chameleon.selenium.windows.elements.WindowsButton;
import com.chameleon.selenium.windows.elements.WindowsCheckbox;
import com.chameleon.selenium.windows.elements.WindowsElement;
import com.chameleon.selenium.windows.elements.WindowsLabel;
import com.chameleon.selenium.windows.elements.WindowsLink;
import com.chameleon.selenium.windows.elements.WindowsListbox;
import com.chameleon.selenium.windows.elements.WindowsRadioGroup;
import com.chameleon.selenium.windows.elements.WindowsTable;
import com.chameleon.selenium.windows.elements.WindowsTextbox;

@SuppressWarnings("unchecked")
public class ExtendedWindowsDriver extends ExtendedDriver {

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
    public <T extends WebElement> List<T> findUIElements(By by) {

        List<org.openqa.selenium.WebElement> elements = driver.findElements(by);
        List<WebElement> el = new ArrayList<>();
        elements.forEach(element -> el.add(new WindowsElement(this, by, element)));
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
    public <T extends WebElement> T findUIElement(By by) {
        return (T) new WindowsElement(this, by);
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
        return (T) new WindowsTextbox(this, by);
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
        List<WindowsTextbox> textboxes = new ArrayList<>();
        elements.forEach(element -> textboxes.add(new WindowsTextbox(this, by, element)));
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
        return (T) new WindowsButton(this, by);
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
        List<WindowsButton> buttons = new ArrayList<>();
        elements.forEach(element -> buttons.add(new WindowsButton(this, by, element)));
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
        return (T) new WindowsCheckbox(this, by);
    }

    @Override
    public <T extends Checkbox> List<T> findCheckboxes(By by) {
        List<org.openqa.selenium.WebElement> elements = findElements(by);
        List<WindowsCheckbox> checkboxes = new ArrayList<>();
        elements.forEach(element -> checkboxes.add(new WindowsCheckbox(this, by, element)));
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
        return (T) new WindowsLabel(this, by);
    }

    @Override
    public <T extends Label> List<T> findLabels(By by) {
        List<org.openqa.selenium.WebElement> elements = findElements(by);
        List<WindowsLabel> labels = new ArrayList<>();
        elements.forEach(element -> labels.add(new WindowsLabel(this, by, element)));
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
        return (T) new WindowsLink(this, by);
    }

    @Override
    public <T extends Link> List<T> findLinks(By by) {
        List<org.openqa.selenium.WebElement> elements = findElements(by);
        List<WindowsLink> links = new ArrayList<>();
        elements.forEach(element -> links.add(new WindowsLink(this, by, element)));
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
        return (T) new WindowsListbox(this, by);
    }

    @Override
    public <T extends Listbox> List<T> findListboxes(By by) {
        List<org.openqa.selenium.WebElement> elements = findElements(by);
        List<WindowsListbox> lists = new ArrayList<>();
        elements.forEach(element -> lists.add(new WindowsListbox(this, by, element)));
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
        return (T) new WindowsRadioGroup(this, by);
    }

    /**
     * Method to find a single Webtable for a given page, using a Selenium <b><i>By</i></b> locator
     *
     * @param by
     *            - Selenium <b><i>By</i></b> locator with which to locate the Webtable
     * @return Webtable, if any, found by using the Selenium <b><i>By</i></b> locator
     * @see http://selenium.googlecode.com/svn/trunk/docs/api/java/org/openqa/selenium/By.html
     * @see http://selenium.googlecode.com/git/docs/api/java/org/openqa/selenium/WebDriver.html#findElement-org.openqa.selenium.By-
     * @see http://github.com/Orasi/Chameleon/blob/master/src/main/java/com/orasi/web/webelements/impl/WebtableImpl.java
     */
    @Override
    public <T extends Table> T findTable(By by) {
        return (T) new WindowsTable(this, by);
    }

    @Override
    public <T extends Table> List<T> findTables(By by) {
        List<org.openqa.selenium.WebElement> elements = findElements(by);
        List<WindowsTable> tables = new ArrayList<>();
        elements.forEach(element -> tables.add(new WindowsTable(this, by, element)));
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
    public WindowsElement findElement(By by) {
        return new WindowsElement(this, by);
    }

    @Override
    public void get(String url) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getCurrentUrl() {
        // TODO Auto-generated method stub
        return null;
    }

}
