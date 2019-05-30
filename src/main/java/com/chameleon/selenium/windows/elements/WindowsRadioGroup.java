package com.chameleon.selenium.windows.elements;

import org.openqa.selenium.By;

import com.chameleon.selenium.elements.RadioGroup;
import com.chameleon.selenium.windows.ExtendedWindowsDriver;

public class WindowsRadioGroup extends RadioGroup {

    public WindowsRadioGroup(ExtendedWindowsDriver driver, By by) {
        super(driver, by);
    }
}