package com.accuweather.glacier.m;

import org.openqa.selenium.By;

import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.elements.WebElement;

public class MobileBasePage extends BasePage {

    protected void clickVisibleElement(By by) {
        WebElement element = getDriver().findElement(by);
        element.syncVisible();
        element.scrollIntoView();
        element.click();
    }

}
