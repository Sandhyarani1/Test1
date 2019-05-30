package com.accuweather.glacier.www.pages;

import org.openqa.selenium.By;

import com.accuweather.glacier.BasePage;
import com.accuweather.glacier.api.objects1.Condition;

public class CurrentWeatherPage extends BasePage {
    private final static String DETAILNOW = "//div[@id='detail-now']/./";
    private final static String TEMP_SUMMARY = "//div[@class='temp-summary-overview']/./";
    private final static String PREV_TEMP_SUMMARY = "//div[contains(@class,'temp-summary-prev')]/./";
    
    /*
     * Current Forecast Area
     */
    private By byCurrentTemp = By.xpath(DETAILNOW + "/span[@class='large-temp']");
    private By byCurrentRealFeelTemp = By.xpath(DETAILNOW + "/span[@class='small-temp']");
    private By byCurrentCondition = By.xpath(DETAILNOW + "/span[@class='cond']");
    //private By byCurrentTemp = By.xpath("//div[contains(@id,'content')]/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]");
    //private By byCurrentRealFeelTemp = By.xpath(DETAILNOW + "/span[@class='small-temp']");
    //private By byCurrentCondition = By.xpath("//div[contains(@id,'content')]/div[1]/div[4]/div[1]/div[2]/div[3]");

	
	
	  private By byCurrentWindDirection = By.xpath(DETAILNOW + "/li[@class='wind']"); 
	  private By byCurrentWindSpeed = By.xpath(DETAILNOW + "/li[@class='wind']/strong");
	  private By byCurrentHumidity = By.xpath(DETAILNOW + "/li[contains(text(),'Humidity')]");
	  private By byCurrentPressure = By.xpath(DETAILNOW + "/li[contains(text(),'Pressure')]");
	  private By byCurrentUvIndex = By.xpath(DETAILNOW + "/li[contains(text(),'UV Index')]");
	  private By byCurrentCloudCover = By.xpath(DETAILNOW + "/li[contains(text(),'Cloud Cover')]"); 
	  private By byCurrentCeiling = By.xpath(DETAILNOW + "/li[contains(text(),'Ceiling')]");
	  private By byCurrentDewPoint = By.xpath(DETAILNOW + "/li[contains(text(),'Dew Point')]"); 
	  private By byCurrentVisibility = By.xpath(DETAILNOW + "/li[contains(text(),'Visibility')]");
	 
	 

    private By byTempSummaryNow = By.xpath(TEMP_SUMMARY + "/th[contains(text(),'Now')]/../td");
    private By byTempSummaryYesterday = By.xpath(TEMP_SUMMARY + "/th[contains(text(),'Yesterday')]/../td");
    private By byTempSummaryRealFeel = By.xpath(TEMP_SUMMARY + "/th[contains(text(),'RealFeel')]/../td");
    private By byTempSummaryRealFeelShade = By.xpath(TEMP_SUMMARY + "/th[contains(text(),'Shade')]/../td");
    private By byTempSummaryWindChill = By.xpath(TEMP_SUMMARY + "/th[text()='Wind Chill']/../td");
    private By byTempSummaryDewPoint = By.xpath(TEMP_SUMMARY + "/th[text()='Dew Point']/../td");

    private By byPrevTempSummaryPrevious6Hours = By.xpath(PREV_TEMP_SUMMARY + "/th[text()='Previous 6 Hours']/../td");
    private By byPrevTempSummaryPrevious12Hours = By.xpath(PREV_TEMP_SUMMARY + "/th[text()='Previous 12 Hours']/../td");
    private By byPrevTempSummaryPrevious24Hours = By.xpath(PREV_TEMP_SUMMARY + "/th[text()='Previous 24 Hours']/../td");

    public void validateCurrentConditions(Condition condition) {

        getDriver().page().isDomInteractive(10000);
        getDriver().findElement(byCurrentTemp).syncVisible();

        validate(byCurrentTemp, "Current Panel: Temperature", round(condition.getTemperature().getImperial().getValue(), 0));
        validate(byCurrentRealFeelTemp, "Current Panel: RealFeel Temperature", round(condition.getRealFeelTemperature().getImperial().getValue(), 0));
		validate(byCurrentCondition, "Current Panel: Conditions",condition.getWeatherText()); 
		validate(byCurrentWindDirection, "Current Panel: Wind Direction", "Winds from the " + condition.getWind().getDirection().getLocalized());
		validate(byCurrentWindSpeed, "Current Panel: Wind Speed", round(condition.getWind().getSpeed().getImperial().getValue(), 0));
		validate(byCurrentHumidity, "Current Panel: Humidity", "Humidity: " + round(condition.getRelativeHumidity(), 0) + "%"); 
		validate(byCurrentPressure, "Current Panel: Pressure", "Pressure: " + condition.getPressure().getImperial().getValue()); 
		validate(byCurrentUvIndex, "Current Panel: UV Index", "UV Index: " + condition.getUVIndex());
		validate(byCurrentCloudCover, "Current Panel: Cloud Cover", "Cloud Cover: " + condition.getCloudCover() + "%"); 
		validate(byCurrentCeiling, "Current Panel: Ceiling", "Ceiling: " + round(condition.getCeiling().getImperial().getValue(), 0));
		validate(byCurrentDewPoint, "Current Panel: Dew Point", "Dew Point: " + round(condition.getDewPoint().getImperial().getValue(), 0));
		validate(byCurrentVisibility, "Current Panel: Visibility", "Visibility: " + round(condition.getVisibility().getImperial().getValue(), 0));
		 

        // validate Temperature Summary
        validate(byTempSummaryNow, "Temperature Summmary Panel: Now", round(condition.getTemperature().getImperial().getValue(), 0));
        validate(byTempSummaryYesterday, "Temperature Summmary Panel: Yesterday", getYesterdaysTemperature(condition));
        validate(byTempSummaryRealFeel, "Temperature Summmary Panel: RealFeel", round(condition.getRealFeelTemperature().getImperial().getValue(), 0));
        validate(byTempSummaryRealFeelShade, "Temperature Summmary Panel: RealFeel Shade", round(condition.getRealFeelTemperatureShade().getImperial().getValue(), 0));
        validate(byTempSummaryWindChill, "Temperature Summmary Panel: Wind Chill", round(condition.getWindChillTemperature().getImperial().getValue(), 0));
        validate(byTempSummaryDewPoint, "Temperature Summmary Panel: Dew Point", round(condition.getDewPoint().getImperial().getValue(), 0));
        validate(byPrevTempSummaryPrevious6Hours, "Previous Temperature Summmary Panel: 6 Hours Hi", round(condition.getTemperatureSummary().getPast6HourRange().getMaximum().getImperial().getValue(), 0));
        validate(byPrevTempSummaryPrevious6Hours, "Previous Temperature Summmary Panel: 6 Hours Low", round(condition.getTemperatureSummary().getPast6HourRange().getMinimum().getImperial().getValue(), 0));
        validate(byPrevTempSummaryPrevious12Hours, "Previous Temperature Summmary Panel: 12 Hours Hi", round(condition.getTemperatureSummary().getPast12HourRange().getMaximum().getImperial().getValue(), 0));
        validate(byPrevTempSummaryPrevious12Hours, "Previous Temperature Summmary Panel: 12 Hours Low", round(condition.getTemperatureSummary().getPast12HourRange().getMinimum().getImperial().getValue(), 0));
        validate(byPrevTempSummaryPrevious24Hours, "Previous Temperature Summmary Panel: 24 Hours Hi", round(condition.getTemperatureSummary().getPast24HourRange().getMaximum().getImperial().getValue(), 0));
        validate(byPrevTempSummaryPrevious24Hours, "Previous Temperature Summmary Panel: 24 Hours Low", round(condition.getTemperatureSummary().getPast24HourRange().getMinimum().getImperial().getValue(), 0));
    }

    /**
     * Yesterdays temperature is calculated by Absolute(Past24HourTemperatureDeparture.Imperial.Value) + Temperature.Imperial.Value <br/>
     * Example<br/>
     * x = Past24HourTemperatureDeparture.Imperial.Value = -12<br/>
     * y = Temperature.Imperial.Value = 51<br/>
     * z = Absolute = -1 <- multiplying a number by -1 will negate it by that amount. 45 will become -45 and -9 will become 9<br/>
     * <br/>
     * ( x * z ) + ( y )<br/>
     * ( -12 * -1 ) + ( 51 )<br/>
     * ( 12 ) + ( 51 )<br/>
     * ( 63 ) = Yesterdays temperature<br/>
     *
     * @param condition
     * @return
     */
    private String getYesterdaysTemperature(Condition condition) {
        final double past24HourTemp = condition.getPast24HourTemperatureDeparture().getImperial().getValue();
        return round((past24HourTemp * -1) + condition.getTemperature().getImperial().getValue(), 0);
    }
}
