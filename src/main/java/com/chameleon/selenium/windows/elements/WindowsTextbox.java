package com.chameleon.selenium.windows.elements;

import org.openqa.selenium.By;

import com.chameleon.selenium.elements.Textbox;
import com.chameleon.selenium.windows.ExtendedWindowsDriver;

public class WindowsTextbox extends Textbox {

    public WindowsTextbox(ExtendedWindowsDriver driver, By by) {
        super(driver, by);
    }

    public WindowsTextbox(ExtendedWindowsDriver driver, By by, org.openqa.selenium.WebElement element) {
        super(driver, by, element);
    }
}