package com.chameleon.selenium.windows.by;

import java.io.Serializable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import com.chameleon.Beta;
import com.chameleon.utils.JavaUtilities;

import io.appium.java_client.FindsByFluentSelector;
import io.appium.java_client.MobileSelector;

/**
 * Mechanism used to locate elements within a document. In order to create your own locating
 * mechanisms, it is possible to subclass this class and override the protected methods as required,
 * though it is expected that that all subclasses rely on the basic finding mechanisms provided
 * through static methods of this class:
 *
 * <code>
 * public WebElement findElement(WebDriver driver) {
 *     WebElement element = driver.findElement(By.id(getSelector()));
 *     if (element == null)
 *       element = driver.findElement(By.name(getSelector());
 *     return element;
 * }
 * </code>
 */
public abstract class ByWindows extends By {

    /**
     * @param accessibilityId
     *            The value of the "accessibilityId" attribute to search for
     * @return a By which locates elements by the accessibilityId
     */
    @Beta
    public static ByWindows accessibilityId(final String accessibilityId) {
        if (!JavaUtilities.isValid(accessibilityId)) {
            throw new IllegalArgumentException(
                    "Cannot find elements when show text is null.");
        }

        return new ByAccessibilityId(accessibilityId);
    }

    @Beta
    public static class ByAccessibilityId extends ByWindows implements Serializable {

        private static final long serialVersionUID = 376317282960469555L;

        private final String accessibilityId;

        public ByAccessibilityId(String accessibilityId) {
            this.accessibilityId = accessibilityId;
        }

        @Override
        public List<WebElement> findElements(SearchContext context) {
            return ((FindsByFluentSelector<WebElement>) context).findElements(MobileSelector.ACCESSIBILITY.toString(), accessibilityId);
        }

        @Override
        public WebElement findElement(SearchContext context) {
            return ((FindsByFluentSelector<?>) context).findElement(MobileSelector.ACCESSIBILITY.toString(), accessibilityId);
        }

        @Override
        public String toString() {
            return "By.accessibilityId: " + accessibilityId;
        }
    }
}
