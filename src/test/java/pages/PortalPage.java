package pages;


import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.By;
import utils.MobileActions;

public class PortalPage extends PortalElements {


    public void selecionarLinkPortal() throws InterruptedException {

        MobileActions.clickOnElement(By.xpath("//android.view.View[@content-desc]"), 3);
        MobileActions.waitImplicitly(10);
        trocaDeContexto("Web");

    }

    public void efetuarLoginPortal(String estabelecimento, String senha) {
        MobileActions.waitImplicitly(10);
        MobileActions.clickOnElement(campoEstabelecimento, 5);
        MobileActions.setText(inputCpf, estabelecimento, 3);
        MobileActions.clickOnElement(btnSubmit, 3);
        MobileActions.clickOnElement(inputCpf, 3);
        MobileActions.setText(inputSenha, senha, 3);
        MobileActions.clickOnElement(btnSubmit, 3);
    }

    public void selecionarECnoPortal(String ec) throws InterruptedException {
        MobileActions.clickOnElement(pesquisarEC, 3);
        MobileActions.setText(pesquisarEC, ec, 3);
        MobileActions.clickOnElement(By.xpath("//*[@id='storeBlock_" + ec + "']"), 3);
        String btnPermitir = MobileActions.getText(By.xpath("//button[@id]"), 3);
        System.out.println(btnPermitir);
        MobileActions.clickOnElement(By.xpath("//button[@id]"), 3);
        BasicConfigurator.configure();

//-----------------------------------descomente a esse bloco a baixo para executar a contexto--------------------------//
        trocaDeContexto("Nativo");
        MobileActions.waitExplicitly(5);
    }

}
