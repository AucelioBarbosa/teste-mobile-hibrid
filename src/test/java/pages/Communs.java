package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.TimeoutException;
import utils.MobileActions;
import utils.StartDriver;

import java.util.concurrent.TimeUnit;

public class Communs extends StartDriver {

    public static void clickAbrirApp() {
        MobileActions.clickOnElement(ChatElements.app, 3);
    }

    public static void clickContato() {
        MobileActions.clickOnElement(ChatElements.chatbot, 3);
    }

    public static void escreverMensagen(String msg) {
        try {
            MobileActions.clickOnElement(ChatElements.sendTxtBox,3);
            MobileActions.setText(ChatElements.sendTxtBox,msg,3);
        } catch (TimeoutException e) {
            System.out.println(e);
            retonarOEstadoInicial();
        }
    }

    public static void enviar() {
        try {
            MobileActions.clickOnElement(ChatElements.btnEnviar, 3);
        } catch (TimeoutException e) {
            retonarOEstadoInicial();
        }
    }

    public static void retonarOEstadoInicial() {
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileActions.setText(ChatElements.sendTxtBox, "stopall", 3);
        MobileActions.clickOnElement(ChatElements.btnEnviar, 3);
        MobileActions.clickOnElement(ChatElements.moveVert, 3);
        MobileActions.clickOnElement(ChatElements.maisOpcao, 3);
        MobileActions.clickOnElement(ChatElements.limparConversa, 3);
        MobileActions.clickOnElement(ChatElements.btnLimparConversa, 3);
        MobileActions.clickOnElement(ChatElements.btnWhatsHome, 3);
        for (int i = 0; i < 3; i++) {
            MobileActions.pressButtonNativeBack();
        }
//        getMobile().terminateApp("com.whatsapp");
    }

}
