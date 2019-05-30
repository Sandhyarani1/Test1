package com.chameleon.selenium.windows.elements;

import org.openqa.selenium.By;

import com.chameleon.selenium.elements.Table;
import com.chameleon.selenium.windows.ExtendedWindowsDriver;

public class WindowsTable extends Table {

    public WindowsTable(ExtendedWindowsDriver driver, By by) {
        super(driver, by);
    }

    public WindowsTable(ExtendedWindowsDriver driver, By by, org.openqa.selenium.WebElement element) {
        super(driver, by, element);
    }

}