package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.TimeoutException;
import pages.ChatPage;
import pages.Communs;
import pages.PortalPage;
import utils.StartDriver;

public class SolicitacaoDIRFSteps extends StartDriver {
    PortalPage portal = new PortalPage();


    @Given("^que abra o WhatsApp$")
    public void queAbraOWhatsApp() {
        ChatPage.abrirWathsApp();
    }

    @And("^inicie uma interacao no chat-cielo$")
    public void queInicieUmaInteracaoNo() {
        try {
            ChatPage.iniciarConversar();
        } catch (TimeoutException | InterruptedException e) {
            Communs.retonarOEstadoInicial();
        }
    }

    @And("^seleciona a opcao ([^\"]*) menu principal$")
    public void informaAOpcaoNoMenuPrincipal(String opcao) {
        try {
            ChatPage.opcoesDoMenu(opcao);
        } catch (TimeoutException | InterruptedException e) {
            System.out.println("\n \n Texto do menu principal não foi encotrado" + e + "\n \n ");
            Communs.retonarOEstadoInicial();
        }
    }

    @And("^click no link de login$")
    public void clickNoLinkDeLogin() {
        try {
            portal.selecionarLinkPortal();
        } catch (TimeoutException | InterruptedException e) {
            Communs.retonarOEstadoInicial();
        }
    }

    @And("^efetue o login com estabelecimento ([^\"]*) senha ([^\"]*)$")
    public void efetueOLoginComCPFEASenha(String estabelecimento, String senha) {
        try {
            portal.efetuarLoginPortal(estabelecimento, senha);
        } catch (TimeoutException e) {
            Communs.retonarOEstadoInicial();
        }
    }

    @And("^seleciona a EC ([^\"]*)$")
    public void selecionoAEC(String ec) {
        try {
            portal.selecionarECnoPortal(ec);
        } catch (TimeoutException | InterruptedException e) {
            Communs.retonarOEstadoInicial();
        }
    }

    @When("^retornar ao chat digite a opcao ([^\"]*) - fiz o login$")
    public void informeSeEfetuouOLogin(String opcao) {
        try {
            ChatPage.opcoesDoMenu(opcao);
        } catch (TimeoutException | SessionNotCreatedException | InterruptedException e) {
            Communs.retonarOEstadoInicial();
        }
    }

    @And("^confirmo a EC ([^\"]*)$")
    public void confirmeAEC(String ec) {
        try {
            ChatPage.confirmarEcDeLogin(ec);
        } catch (TimeoutException e) {
            Communs.retonarOEstadoInicial();
        }
    }

    @And("^escolha a opcao \"([^\"]*)\" do submenu$")
    public void escolhaAOpcaoSubMenu(String opcao) {
        try {
            ChatPage.opcoesDoMenu(opcao);

        } catch (TimeoutException | InterruptedException e) {
            Communs.retonarOEstadoInicial();
        }
    }

    @And("^escolha a opcao \"([^\"]*)\" do menu de cosulta$")
    public void escolhaAOpcaoInformarOutroAno(String opcao) {
        try {
            ChatPage.opcoesDoMenu(opcao);
        } catch (TimeoutException e) {
            Communs.retonarOEstadoInicial();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("^informo o ano ([^\"]*) de solitacao do DIRF$")
    public void informoOAno(String anoSolicitacao) {
        try {
            ChatPage.informarAdicionais(anoSolicitacao);

        } catch (TimeoutException e) {
            Communs.retonarOEstadoInicial();
        }
    }

    @And("^informo outro ano ([^\"]*) de solitacao do DIRF$")
    public void informoOutroAno(String anoSolicitacao) {
        try {
            ChatPage.informarAdicionais(anoSolicitacao);

        } catch (TimeoutException e) {
            Communs.retonarOEstadoInicial();
        }
    }

    @Given("^informo outro email \"([^\"]*)\"$")
    @And("^informo o email \"([^\"]*)\"$")
    public void informoOEMail(String email) {
        try {
            ChatPage.informarAdicionais(email);
        } catch (TimeoutException e) {
            Communs.retonarOEstadoInicial();
        }
    }

    @Then("^o retona texto deve conter o link \"([^\"]*)\"$")
    public void oRetonoDoFormularioComOTexto(String url) {
        try {
            ChatPage.validandoMensagemTexto(url);

        } catch (TimeoutException e) {
            Communs.retonarOEstadoInicial();
        }
    }

    @Then("^seleciono opcao envia para outro email ([^\"]*)$")
    public void celecionoEnviaParaOutroEmail(String opcao) {
        try {
            ChatPage.opcoesDoMenu(opcao);
        } catch (TimeoutException | InterruptedException e) {
            Communs.retonarOEstadoInicial();
        }
    }

    @Then("^exibe menu com as opcoes$")
    public void exibeMenuComAsOpcoes() {

    }

    @And("^encerro o chat$")
    public void encerroOChat() {

        Communs.retonarOEstadoInicial();
    }
}
