package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SeuBarrigaActivity;
import pages.SeuBarrigaElemente;
import utils.MobileActions;

public class SeuBarrigatepdefs {
    @Given("^inciado uma sessão no app$")
    public void inciadoUmaSessaoNoApp() {
        SeuBarrigaActivity.abrirAp();
    }

    @And("^clicado no opção seu barriga híbrido$")
    public void voidclicadoNaOpcaoSeuBarrigaHibrido() {
        SeuBarrigaActivity.escolherOpcao();
    }

    @When("^efetuado o login$")
    public void efetuarLogin() {
        SeuBarrigaActivity.preencherCampos();
    }

    @Then("^valido se consegui realizar ações na tela Web_viwer$")
    public void validarSeConseguiRealizaAtrocaDeContexto() {
        SeuBarrigaActivity.menu("Criar Movimentação");
        MobileActions.waitExplicitly(4);
        SeuBarrigaActivity.menu("Sair");
    }

}
