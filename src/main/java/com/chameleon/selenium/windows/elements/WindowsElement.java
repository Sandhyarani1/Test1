package com.chameleon.selenium.windows.elements;

import static com.chameleon.utils.TestReporter.logTrace;

import java.util.List;

import org.openqa.selenium.By;

import com.chameleon.selenium.elements.Element;
import com.chameleon.selenium.windows.ExtendedWindowsDriver;

/**
 * An ementation of the Element interface. Delegates its work to an
 * underlying WebElement instance for custom functionality.
 */
public class WindowsElement extends Element {

    public WindowsElement(final ExtendedWindowsDriver driver, final By by) {
        super(driver, by);
    }

    public WindowsElement(final ExtendedWindowsDriver driver, final By by, final org.openqa.selenium.WebElement element) {
        super(driver, by, element);
    }

    /**
     * @see org.openqa.selenium.WebElement#findElement(By)
     */
    @SuppressWarnings("unchecked")
    @Override
    public WindowsElement findElement(By by) {
        logTrace("Entering Element#findWebElement");
        WindowsElement el = getWrappedElement().findElement(by);
        logTrace("Exiting Element#findWebElement");
        return el;
    }

    /**
     * @see org.openqa.selenium.WebElement#findElement(By)
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<WindowsElement> findElements(By by) {
        logTrace("Entering Element#findWebElements");
        List<WindowsElement> elements = getWrappedElement().findElements(by);
        logTrace("Exiting Element#findWebElements");
        return elements;
    }

}
