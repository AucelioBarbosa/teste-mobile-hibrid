package utils;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class MobileActions extends StartDriver {

    public static void setText(By element, String text, int seconds) {
        getDriver().findElement(element).setValue(text);
        waitImplicitly(seconds);
    }

    public static void clickOnElement(By element, int seconds) {
        getDriver().findElement(element).click();
        waitImplicitly(seconds);
    }



    public static String getText(By element, int seconds) {
        String text = getDriver().findElement(element).getText();
        waitImplicitly(seconds);
        return text;
    }

    public static String getTextAttribut(By element, String attribut, int seconds) {
        String text = getDriver().findElement(element).getAttribute(attribut);
        waitImplicitly(seconds);
        return text;
    }

    public static void pressButtonNativeBack() {
        getDriver().pressKey(new KeyEvent(AndroidKey.BACK));
    }

    public static void pressButtonNativeAppSwitch() {
        getDriver().pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
    }

    public static void pressButtonNativeHome() {
        getDriver().pressKey(new KeyEvent(AndroidKey.HOME));
    }

    public static void waitImplicitly(int seconds) {
        getDriver().manage().timeouts().implicitlyWait((long) seconds * 1000L, TimeUnit.SECONDS);
    }

    public static void waitExplicitly(int seconds) {
        try {
            Thread.sleep((long) seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
