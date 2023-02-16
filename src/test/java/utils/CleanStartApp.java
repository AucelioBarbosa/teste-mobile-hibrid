package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import pages.Communs;

public class CleanStartApp extends StartDriver {
    public static void cleansStartWhatsApp() {
        do {
            cieloSTG();
            cieloUAT();
            agenteUFTAberto();
            pesquisaAPPAberto();
            atualizacaoDeSoftware();
        } while (agenteUFTAberto() && cieloSTG() && pesquisaAPPAberto() && cieloUAT() && atualizacaoDeSoftware());
    }

    public static boolean agenteUFTAberto() {

        try {
            String uft = MobileActions.getText(By.xpath("//*[@text='UFTM Agent']"), 3);
            if (uft.equals("UFTM Agent")) {
                System.out.println("\n UFTM Agent aberto!\n");
                    MobileActions.pressButtonNativeBack();
                    MobileActions.pressButtonNativeBack();
                    MobileActions.pressButtonNativeBack();
            }
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public static boolean cieloSTG() {
        try {
            String chatAbertoSTG = MobileActions.getText(By.xpath("//*[@text='Cielo-STG']"), 3);
            if (chatAbertoSTG.equals("Cielo-STG")) {
                System.out.println("\nCielo-STG aberto!\n");
                Communs.retonarOEstadoInicial();

            }
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public static boolean cieloUAT() {
        try {
            String chatAbertoUAT = MobileActions.getText(By.xpath("//*[@text='Cielo-UAT']"), 3);
            if (chatAbertoUAT.equals("Cielo-UAT")) {
                System.out.println("\nCielo-UAT aberto!\n");
            }
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public static boolean pesquisaAPPAberto() {
        try {
            String chatAberto = MobileActions.getText(By.xpath("//*[@text='Pesquisar']"), 3);
            if (chatAberto.equals("Pesquisar")) {
                System.out.println("\n Pesquisar app aberto!\n");
                MobileActions.pressButtonNativeBack();
            }
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public static boolean atualizacaoDeSoftware() {
        try {
            String atualizacao = MobileActions.getText(By.xpath("//*[@text='Atualização de software']"), 3);
            if (atualizacao.equals("Atualização de software")) {
                System.out.println("\n Atualização de software \n ");
                MobileActions.pressButtonNativeBack();
            }
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}

