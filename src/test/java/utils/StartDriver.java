package utils;

import devices.DeviceMap;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class StartDriver {

    private static AndroidDriver<MobileElement> driver;

    public static AndroidDriver<MobileElement> getDriver() {
        if (driver == null) {
            createTestObjectDriver();
        }
        return driver;
    }

    private static void createTestObjectDriver() {

        try {
            driver = new AndroidDriver<MobileElement>(new URL("http://labmobilecielo.keeggo.com:443/wd/hub"), DeviceMap.deviceModel("A10"));
//            driver = new AndroidDriver<MobileElement>(new URL("127.0.0.1:4723/wd/hub"), DeviceMap.deviceModel("A10"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        //espera implicita
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void killDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void trocaDeContexto(String contexto) {
        try {
            Set<String> contexts = getDriver().getContextHandles();
            System.out.println("\n");
            for (String context : contexts) {
                System.out.println(context);
            }
            switch (contexto) {
                case "Web":
                    getDriver().context((String) contexts.toArray()[1]);
                    System.out.println("contexto " + contexts.toArray()[1] + "\n");
                    break;
                case "Nativo":
                    getDriver().context((String) contexts.toArray()[0]);
                    System.out.println("contexto " + contexts.toArray()[0] + "\n");
                    break;
                default:
                    System.out.println("Contexto não encontrado");
                    break;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            MobileActions.pressButtonNativeBack();
        }
    }
}
