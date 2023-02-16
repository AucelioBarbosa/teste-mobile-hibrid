package utils;

import br.com.cielo.feather.setup.ConfigFramework;
import br.com.cielo.feather.setup.ExtentReports;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import mobilePom.ServiceAppointmentPO;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DSL extends StartDriver {

    public static void esperaImplicita(int seconds) {
        getDriver().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public static Boolean isElementoPresente(By by, int seconds) {
        try {
            esperaImplicita(seconds);
            getDriver().findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static Boolean isElementoPresenteById(String id, int seconds) {
        try {
            Thread.sleep(3000);
            esperaImplicita(seconds);
            getDriver().findElementsById(id);
            return true;
        } catch (NoSuchElementException | InterruptedException e) {
            return false;
        }
    }


    public static Point extraiCoordenadasElemento(MobileElement element) {
        try {
            boolean isDisplayed = element.isDisplayed();
            Assert.assertTrue(isDisplayed);
        } catch (Exception e) {
            e.printStackTrace();
            ExtentReports.appendToReport(getDriver(), "O elemento a ser extraido não esta disponivel na tela");
        }
        Point coordenadas = element.getLocation();
        return coordenadas;
    }

    public static Point extraiCoordenadasElementoWebElement(WebElement element) {
        Point coordenadas = element.getLocation();
        return coordenadas;
    }

    public static void clicarPorTexto(String texto) {
        getDriver().findElement(By.xpath("//*[@text='" + texto + "']")).click();
    }

    public static void selecionarCombo(By by, String valor, int espera) {
        esperaImplicita(espera);
        getDriver().findElement(by).click();
        clicarPorTexto(valor);
    }

    //scrola ate encontrar o elemento pelo texto
    public static MobileElement scrollToText(AndroidDriver<MobileElement> driver, String text) {
        MobileElement el = (MobileElement) driver.findElementByAndroidUIAutomator("new UiScrollable("
                + "new UiSelector().scrollable(true)).scrollIntoView(" + "new UiSelector().text(\"" + text + "\"));");
        return el;
    }

    //scrola ate encontrar o elemento pelo id
    public static MobileElement scrollToId(AndroidDriver<MobileElement> driver, String id) {
        return (MobileElement) driver.findElementByAndroidUIAutomator(
                "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
                        + "new UiSelector().resourceIdMatches(\"" + id + "\"));");
    }

    public static void encontrarElementoEclicarPorCoordenada(String elemento, String tipo) {
        AndroidDriver driver = (AndroidDriver) getDriver();

        if (tipo.equalsIgnoreCase("text")) {
            MobileElement el = DSL.scrollToText(driver, elemento);
            Point coord = DSL.extraiCoordenadasElemento(el);
            System.out.println("coordenadas: " + coord);
            try {
                DSL.esperaImplicita(20);
                TouchAction action = new TouchAction(driver);
                action.tap(PointOption.point(coord)).perform();
            } catch (NoSuchElementException e) {
                ExtentReports.appendToReport(getDriver(), "Não foi possivel clicar no elemento pela coordenada");
                Assert.fail();
            }
        } else if (tipo.equalsIgnoreCase("id")) {
            try {
                DSL.esperaImplicita(20);
                MobileElement el = DSL.scrollToId(driver, elemento);
                DSL.esperaImplicita(20);
                Point coord = DSL.extraiCoordenadasElemento(el);
                DSL.esperaImplicita(20);
                TouchAction action = new TouchAction(driver);
                action.tap(PointOption.point(coord)).perform();
            } catch (NoSuchElementException e) {
                ExtentReports.appendToReport(getDriver(), "Não foi possivel clicar no elemento pela coordenada");
                Assert.fail();
            }


        } else {
            Assert.fail("Opção de tipo não existente, escolha 'text' ou 'id'");
        }

    }

    public static MobileElement getClickableElemento(WebDriver driver, MobileElement element, int seconds) {
        return (MobileElement) (new WebDriverWait(driver, (long) seconds)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void click(WebDriver driver, MobileElement element, int seconds) {
        MobileElement element2 = getClickableElemento(driver, element, seconds);
        element2.click();
    }

    public static String pegaTextodeCampos(String nomeCampo, int time) {
        return getTextMobile(ServiceAppointmentPO.labelPreenchidaAPartirDeCamposBY(nomeCampo), time);
    }


    public static void clicarPorCoordenadas(int x, int y) {
        TouchAction action = new TouchAction(getDriver());
        action.tap(PointOption.point(x, y)).perform();
        ExtentReports.appendToReport(getDriver(), "clicando na coordenada: X:" + x + " Y:" + y);
    }

    public static Boolean encontrarElementoMobileEclicarPorCoordenada(MobileElement by, int tempo) {
        DSL.esperaImplicita(tempo);
        Point coord = extraiCoordenadasElemento(by);
        System.out.println("coordenadas: " + coord);
        try {
            DSL.esperaImplicita(tempo);
            TouchAction action = new TouchAction(getDriver());
            action.tap(PointOption.point(coord)).perform();
            return true;
        } catch (NoSuchElementException e) {
            ExtentReports.appendToReport(getDriver(), "Não foi possivel clicar no elemento pela coordenada");
            return false;
        }
    }


    public static void encontrarElementoMobileEclicarPorCoordenadaWebElement(WebElement by, int tempo) {
        //AndroidDriver driver = (AndroidDriver) getDriver()();

        DSL.esperaImplicita(tempo);
        Point coord = DSL.extraiCoordenadasElementoWebElement(by);
        System.out.println("coordenadas: " + coord);
        try {
            DSL.esperaImplicita(tempo);
            TouchAction action = new TouchAction(getDriver());
            action.tap(PointOption.point(coord)).perform();
        } catch (NoSuchElementException e) {
            ExtentReports.appendToReport(getDriver(), "Não foi possivel clicar no elemento pela coordenada");
            Assert.fail();
        }

    }

    public static MobileElement getVisibleElement(WebDriver driver, By by, int seconds) {
        return (MobileElement) (new WebDriverWait(driver, (long) seconds)).until(ExpectedConditions.visibilityOfElementLocated(by));
    }


    public static String getTextMobile(By by, int seconds) {
        String textExtracted = null;
        MobileElement element2 = getVisibleElement(getDriver(), by, seconds);
        if (element2 != null) {
            textExtracted = element2.getText().trim();
        } else {
            Assert.fail("Falha ao capturar o valor do elemento.");
        }
        return textExtracted;
    }


    public static void scrollDown() {
        Dimension dimension = getDriver().manage().window().getSize();
        Double scrollHeightStart = dimension.getHeight() * 0.5;
        int scrollStart = scrollHeightStart.intValue();
        Double scrollHeightEnd = dimension.getHeight() * 0.2;
        int scrollEnd = scrollHeightEnd.intValue();
        new TouchAction((PerformsTouchActions) getDriver())
                .press(PointOption.point(0, scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(0, scrollEnd))
                .release().perform();
    }

    public static void scrollUp() {
        Dimension dimension = getDriver().manage().window().getSize();
        Double scrollHeightStart = dimension.getHeight() * 0.2;
        int scrollStart = scrollHeightStart.intValue();
        Double scrollHeightEnd = dimension.getHeight() * 0.9;
        int scrollEnd = scrollHeightEnd.intValue();
        new TouchAction((PerformsTouchActions) getDriver())
                .press(PointOption.point(0, scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(0, scrollEnd))
                .release().perform();
    }


    //Depois ver pq esta errado
    public void swipe(double inicio, double fim) {
        AndroidDriver driver = (AndroidDriver) getDriver();
        Dimension size = getDriver().manage().window().getSize();
        int y = size.height / 2;
        int start_x = (int) (size.width * inicio);
        int end_x = (int) (size.width * fim);

        new TouchAction(getDriver())
                //  .press(start_x, y)
                // .waitAction(Duration.ofMillis(500))
                //.moveTo(end_x, y)
                .release()
                .perform();
    }

    /**
     * Realiza Scroll no mobile ate encontrar o elemento solicitado, seja para baixo, seja para cima
     *
     * @param by         - Elemento a ser procurado
     * @param seconds    - tempo de espera a cada scroll
     * @param tipoScroll - tipo de scroll, valores possiveis: baixo e cima
     * @return void
     * @author ricardo.vaz.d.junior
     */
    public static void scrollTillElementBy(By by, int seconds, String tipoScroll) {
        if (tipoScroll.equalsIgnoreCase("baixo")) {
            while (Boolean.FALSE.equals(DSL.isElementoPresente(by, seconds))) {
                Assert.assertTrue("O aplicativo foi encerrado indevidamente", DSL.isElementoPresente(ServiceAppointmentPO.framePrincipal, seconds));
                ExtentReports.appendToReport(getDriver(), "Descendo a tela ate achar o elemento desejado...");
                scrollDown();
            }
            if (Boolean.TRUE.equals(DSL.isElementoPresente(by, seconds))) {
                ExtentReports.appendToReport(getDriver(), "Elemento encontrado!");
            }
        } else if (tipoScroll.equalsIgnoreCase("cima")) {
            while (Boolean.FALSE.equals(DSL.isElementoPresente(by, seconds))) {
                Assert.assertTrue("O aplicativo foi encerrado indevidamente", DSL.isElementoPresente(ServiceAppointmentPO.framePrincipal, seconds));
                ExtentReports.appendToReport(getDriver(), "Subindo a tela ate achar o elemento desejado...");
                scrollUp();
            }
            if (Boolean.TRUE.equals(DSL.isElementoPresente(by, seconds))) {
                ExtentReports.appendToReport(getDriver(), "Elemento encontrado!");
            }
        }
    }

}
