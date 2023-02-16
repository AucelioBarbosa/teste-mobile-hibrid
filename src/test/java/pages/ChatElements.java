package pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.StartDriver;

public class ChatElements extends StartDriver {

//    public ChatElements() {
//        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
//    }
    public static By app = By.xpath("//*[@content-desc='WhatsApp']");
    public static By chatbot = By.xpath("//android.widget.RelativeLayout");
    public static By sendTxtBox = By.id("com.whatsapp:id/entry");
    public static By btnEnviar = By.id("com.whatsapp:id/send");
    public static By moveVert = By.xpath("//android.widget.ImageView[@content-desc='Mais opções']");
    public static By maisOpcao = By.xpath("//android.widget.ImageView[@resource-id='com.whatsapp:id/submenuarrow']");
    public static By limparConversa = By.xpath("//android.widget.TextView[@text='Limpar conversa']");
    public static By btnLimparConversa = By.xpath("//android.widget.Button[@resource-id='android:id/button1']");
    public static By btnWhatsHome = By.xpath("//android.widget.ImageView[@resource-id='com.whatsapp:id/whatsapp_toolbar_home']");

    public static By txBox1 = By.xpath("//android.view.ViewGroup[1]/android.widget.LinearLayout[1]//android.widget.FrameLayout/android.widget.TextView");
    public static By txBox2 = By.xpath("//android.view.ViewGroup[2]/android.widget.LinearLayout[1]//android.widget.FrameLayout/android.widget.TextView");
    public static By txBox3 = By.xpath("//android.view.ViewGroup[3]/android.widget.LinearLayout[1]//android.widget.FrameLayout/android.widget.TextView");
    public static By txBox4 = By.xpath("//android.view.ViewGroup[4]/android.widget.LinearLayout[1]//android.widget.FrameLayout/android.widget.TextView");
    public static By txBox5 = By.xpath("//android.view.ViewGroup[5]/android.widget.LinearLayout[1]//android.widget.FrameLayout/android.widget.TextView");
    public static By txBox6 = By.xpath("//android.view.ViewGroup[6]/android.widget.LinearLayout[1]//android.widget.FrameLayout/android.widget.TextView");
    public static By txBox7 = By.xpath("//android.view.ViewGroup[7]/android.widget.LinearLayout[1]//android.widget.FrameLayout/android.widget.TextView");
    public static By contatos = By.xpath("//android.widget.RelativeLayout[1]");

}

