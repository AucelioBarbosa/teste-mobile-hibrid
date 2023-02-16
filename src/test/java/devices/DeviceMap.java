package devices;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.PropertiesManger;

public class DeviceMap {

    public static DesiredCapabilities deviceModel(String model){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        PropertiesManger userMobileCenter = new PropertiesManger("src/test/resources/properties/mobile.properties");
        switch (model) {
            case "J4":
                capabilities.setCapability("oauthClientId", userMobileCenter.getProps().getProperty("oauthClientId"));
                capabilities.setCapability("oauthClientSecret", userMobileCenter.getProps().getProperty("oauthClientSecret"));
                capabilities.setCapability("udid", userMobileCenter.getProps().getProperty("udid_J4"));
                capabilities.setCapability("platformVersion", userMobileCenter.getProps().getProperty("platformVersion_J4"));
                capabilities.setCapability (CapabilityType.ACCEPT_SSL_CERTS, false);
                capabilities.setCapability(MobileCapabilityType.AUTO_WEBVIEW, false);
                capabilities.setCapability("tenantId", userMobileCenter.getProps().getProperty("tenantId"));
                capabilities.setCapability("mcWorkspaceName", userMobileCenter.getProps().getProperty("mcWorkspaceName"));
                capabilities.setCapability("browserName", "");
                capabilities.setCapability("noReset", true);
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("automationName", "UiAutomator2");
                capabilities.setCapability("appPackage", userMobileCenter.getProps().getProperty("packageID"));
                capabilities.setCapability("appActivity", userMobileCenter.getProps().getProperty("activity"));
                break;
            case "A10":
                capabilities.setCapability("oauthClientId", userMobileCenter.getProps().getProperty("oauthClientId"));
                capabilities.setCapability("oauthClientSecret", userMobileCenter.getProps().getProperty("oauthClientSecret"));
                capabilities.setCapability("udid", userMobileCenter.getProps().getProperty("udid_A10"));
                capabilities.setCapability("platformVersion", userMobileCenter.getProps().getProperty("platformVersion_A10"));
//                capabilities.setCapability (CapabilityType.ACCEPT_SSL_CERTS, false);
                capabilities.setCapability(MobileCapabilityType.AUTO_WEBVIEW, false);
                capabilities.setCapability("tenantId", userMobileCenter.getProps().getProperty("tenantId"));
                capabilities.setCapability("mcWorkspaceName", userMobileCenter.getProps().getProperty("mcWorkspaceName"));
                capabilities.setCapability("browserName", "");
                capabilities.setCapability("noReset", true);
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("automationName", "UiAutomator2");
                break;
            case "S8":
                capabilities.setCapability("oauthClientId", userMobileCenter.getProps().getProperty("oauthClientId"));
                capabilities.setCapability("oauthClientSecret", userMobileCenter.getProps().getProperty("oauthClientSecret"));
                capabilities.setCapability("udid", userMobileCenter.getProps().getProperty("udid_S8"));
                capabilities.setCapability("platformVersion", userMobileCenter.getProps().getProperty("platformVersion_S8"));
                capabilities.setCapability (CapabilityType.ACCEPT_SSL_CERTS, false);
                capabilities.setCapability(MobileCapabilityType.AUTO_WEBVIEW, false);
                capabilities.setCapability("tenantId", userMobileCenter.getProps().getProperty("tenantId"));
                capabilities.setCapability("mcWorkspaceName", userMobileCenter.getProps().getProperty("mcWorkspaceName"));
                capabilities.setCapability("browserName", "");
                capabilities.setCapability("noReset", true);
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("automationName", "UiAutomator2");
                break;
            default:
                System.out.println("Device " + model + " não está definido");
                break;
        }
        return capabilities;
    }
}
