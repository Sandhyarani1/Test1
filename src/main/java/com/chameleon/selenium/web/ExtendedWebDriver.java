package com.chameleon.selenium.web;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.chameleon.selenium.ExtendedDriver;
import com.chameleon.selenium.elements.Button;
import com.chameleon.selenium.elements.Checkbox;
import com.chameleon.selenium.elements.Label;
import com.chameleon.selenium.elements.Link;
import com.chameleon.selenium.elements.Listbox;
import com.chameleon.selenium.elements.RadioGroup;
import com.chameleon.selenium.elements.Table;
import com.chameleon.selenium.elements.Textbox;
import com.chameleon.selenium.web.elements.WebButton;
import com.chameleon.selenium.web.elements.WebCheckbox;
import com.chameleon.selenium.web.elements.WebElement;
import com.chameleon.selenium.web.elements.WebLabel;
import com.chameleon.selenium.web.elements.WebLink;
import com.chameleon.selenium.web.elements.WebListbox;
import com.chameleon.selenium.web.elements.WebRadioGroup;
import com.chameleon.selenium.web.elements.WebTable;
import com.chameleon.selenium.web.elements.WebTextbox;

@SuppressWarnings("unchecked")
public class ExtendedWebDriver extends ExtendedDriver {
    private int currentScriptTimeout;

    public ExtendedWebDriver() {
    }

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
    public <T extends WebElement> List<T> findWebElements(By by) {

        List<org.openqa.selenium.WebElement> elements = driver.findElements(by);
        List<WebElement> el = new ArrayList<>();
        elements.forEach(element -> el.add(new WebElement(this, by, element)));
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
        return (T) new WebTextbox(this, by);
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
        List<WebTextbox> textboxes = new ArrayList<>();
        elements.forEach(element -> textboxes.add(new WebTextbox(this, by, element)));
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
        return (T) new WebButton(this, by);
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
        List<WebButton> buttons = new ArrayList<>();
        elements.forEach(element -> buttons.add(new WebButton(this, by, element)));
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
        return (T) new WebCheckbox(this, by);
    }

    @Override
    public <T extends Checkbox> List<T> findCheckboxes(By by) {
        List<org.openqa.selenium.WebElement> elements = findElements(by);
        List<WebCheckbox> checkboxes = new ArrayList<>();
        elements.forEach(element -> checkboxes.add(new WebCheckbox(this, by, element)));
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
        return (T) new WebLabel(this, by);
    }

    @Override
    public <T extends Label> List<T> findLabels(By by) {
        List<org.openqa.selenium.WebElement> elements = findElements(by);
        List<WebLabel> labels = new ArrayList<>();
        elements.forEach(element -> labels.add(new WebLabel(this, by, element)));
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
        return (T) new WebLink(this, by);
    }

    @Override
    public <T extends Link> List<T> findLinks(By by) {
        List<org.openqa.selenium.WebElement> elements = findElements(by);
        List<WebLink> links = new ArrayList<>();
        elements.forEach(element -> links.add(new WebLink(this, by, element)));
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
        return (T) new WebListbox(this, by);
    }

    @Override
    public <T extends Listbox> List<T> findListboxes(By by) {
        List<org.openqa.selenium.WebElement> elements = findElements(by);
        List<WebListbox> lists = new ArrayList<>();
        elements.forEach(element -> lists.add(new WebListbox(this, by, element)));
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
        return (T) new WebRadioGroup(this, by);
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
        return (T) new WebTable(this, by);
    }

    @Override
    public <T extends Table> List<T> findTables(By by) {
        List<org.openqa.selenium.WebElement> elements = findElements(by);
        List<WebTable> tables = new ArrayList<>();
        elements.forEach(element -> tables.add(new WebTable(this, by, element)));
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
    public WebElement findElement(By by) {
        return new WebElement(this, by);
    }

    /**
     * Method to execute a user-defined JavaScript
     *
     * @param script
     *            script to be executed
     * @param parameters
     *            any parameters that may need to be referenced by the script
     * @return Return value types vary based on the return type of the script
     * @see http://selenium.googlecode.com/svn/trunk/docs/api/java/org/openqa/selenium/JavascriptExecutor.html
     */
    public Object executeJavaScript(String script, Object... parameters) {
        return ((JavascriptExecutor) driver).executeScript(script, parameters);
    }

    /**
     * Method to execute a user-defined JavaScript
     *
     * @param script
     *            script to be executed
     * @param parameters
     *            any parameters that may need to be referenced by the script
     * @return Return value types vary based on the return type of the script
     * @see http://selenium.googlecode.com/svn/trunk/docs/api/java/org/openqa/selenium/JavascriptExecutor.html
     */
    public Object executeAsyncJavaScript(String script, Object... parameters) {
        return ((JavascriptExecutor) driver).executeAsyncScript(script, parameters);
    }

    /**
     * Method that return the <b><i>PageLoaded</i></b> class
     *
     * @return <b><i>PageLoaded</i></b> class
     */
    public Page page() {
        return new Page();
    }

    public class Page {
        public boolean isAngularComplete() {
            return WebPageLoaded.isAngularComplete();
        }

        public boolean isDomComplete() {
            return WebPageLoaded.isDomComplete();
        }

        public boolean isDomComplete(int timeout) {
            return WebPageLoaded.isDomComplete(timeout);
        }

        public boolean isJQueryComplete() {
            return WebPageLoaded.isJQueryComplete();
        }

        public boolean isJQueryComplete(int timeout) {
            return WebPageLoaded.isJQueryComplete(timeout);
        }

        public boolean isDomInteractive() {
            return WebPageLoaded.isDomInteractive();
        }

        public boolean isDomInteractive(int timeout) {
            return WebPageLoaded.isDomInteractive(timeout);
        }
    }

}