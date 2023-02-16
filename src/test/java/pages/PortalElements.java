package pages;

import org.openqa.selenium.By;
import utils.StartDriver;

public class PortalElements extends StartDriver {

    public static By campoEstabelecimento = By.xpath("//*[@id='loginMainField']");
    public static By inputCpf = By.xpath("//*[@id='loginMainField']/div/input");
    public static By inputSenha = By.xpath("//*[@id='flui-input-1']/div/input");
    public static By btnSubmit = By.xpath("//button[@id='bt-submit']");
    public static By pesquisarEC = By.xpath("//*[@id='storeSearchField']/div/input");

    public static By msgAutenticacao = By.xpath("//*/app-login-external/div/div/h1");
    public static By subMsgAutenticacao = By.xpath("//*/p/text()");

    public static String msgPaginaAutenticacao;

    public static String getMsgPaginaAutenticacao() {
        return msgPaginaAutenticacao;
    }

    public static void setMsgPaginaAutenticacao(String msgH1, String msgP) {
        PortalElements.msgPaginaAutenticacao = (msgH1 + msgP);
    }

    public static String url;

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        PortalPage.url = url;
    }
}
