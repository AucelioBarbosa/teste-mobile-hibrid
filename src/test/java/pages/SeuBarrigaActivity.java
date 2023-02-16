package pages;

import io.cucumber.java.eo.Se;
import utils.MobileActions;

public class SeuBarrigaActivity extends SeuBarrigaElemente {

    public static void abrirAp() {
        MobileActions.clickOnElement(SeuBarrigaElemente.app, 3);
    }

    public static void escolherOpcao() {
        MobileActions.clickOnElement(SeuBarrigaElemente.CelularHibrid, 4);
    }

    public static void preencherCampos() {
        MobileActions.clickOnElement(SeuBarrigaElemente.campoEmail, 3);
        MobileActions.setText(SeuBarrigaElemente.campoEmail, "aucelio.teste@gmail.com", 3);
        MobileActions.clickOnElement(SeuBarrigaElemente.campoSenha, 3);
        MobileActions.setText(SeuBarrigaElemente.campoSenha, "teste_014", 3);
        MobileActions.clickOnElement(SeuBarrigaElemente.btnEntrar, 3);
    }


    public static void menu(String opcao) {
        switch (opcao) {
            case "Home":
                MobileActions.clickOnElement(menuHome,3);
                break;
            case "Criar Movimentação":
                MobileActions.clickOnElement(menuMobimentacao,3);
                break;
            case "Contas":
                MobileActions.clickOnElement(menuContas,3);
                break;
            case "Resumo Mensal":
                MobileActions.clickOnElement(menuResumoMensal,3);

                break;
            case "Sair":
                MobileActions.clickOnElement(menuSair,3);
                break;
            default:
                System.out.println(opcao + "não encontrada");
        }

    }
}
