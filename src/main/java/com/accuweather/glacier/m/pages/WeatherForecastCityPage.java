package com.accuweather.glacier.m.pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

import com.accuweather.glacier.m.MobileBasePage;
import com.chameleon.selenium.elements.Label;
import com.chameleon.utils.Sleeper;

public class WeatherForecastCityPage extends MobileBasePage {
    private By currentCityLabel = By.xpath("//div[@id='current']/h2");

    public boolean isExpectedCityDisplayed(String dropdownCity, String dropDownState) {
        Label lblCity = getDriver().findLabel(currentCityLabel);
        lblCity.syncVisible(15);

        Sleeper.sleep(3);
        final String dropdownCityValue = dropdownCity + (StringUtils.isEmpty(dropDownState) ? "" : ", " + dropDownState);
        return lblCity.syncTextInElement(dropdownCityValue, 30, false);
    }
}
