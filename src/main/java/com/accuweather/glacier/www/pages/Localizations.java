package com.accuweather.glacier.www.pages;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.accuweather.glacier.BasePage;
import com.chameleon.selenium.web.elements.WebElement;

public class Localizations extends BasePage
{
	public void selectOptionWithText(String textToSelect) {
		try {
			//WebElement autoOptions = getDriver().findElement(By.cssSelector(("div.searchbar.featured-search > div.search-results > div.search-bar-result.search-result")));

			List<WebElement> optionsToSelect = getDriver().findElements(By.cssSelector(("div.searchbar.featured-search > div.search-results > div.search-bar-result.search-result")));
			System.out.println(optionsToSelect.get(0).getText());
			for(WebElement option : optionsToSelect){
		        if(option.getText().equals(textToSelect)) {
		        	System.out.println("Trying to select: "+textToSelect);
		            option.click();
		            break;
		        }
		    }
			
		} catch (NoSuchElementException e) {
			System.out.println(e.getStackTrace());
		}
		catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
}
