package pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import utils.CleanStartApp;
import utils.MobileActions;

import static pages.Communs.*;


public class ChatPage extends ChatElements {

    /*------------------------------------- abertura do app WhatsApp ----------------------------------*/

    public static void abrirWathsApp() {
//        CleanStartApp.cleansStartWhatsApp();
        try {
            clickAbrirApp();
        } catch (TimeoutException e) {
            System.out.println("elemento não encontrado" + e);
        }

    }

    public static void iniciarConversar() throws InterruptedException {
        clickContato();
        escreverMensagen("oi");
        enviar();
        Thread.sleep(10);
    }

    public static void confirmarEcDeLogin(String ec) {
        try {
            Thread.sleep(10);
            String ecChat = MobileActions.getTextAttribut(By.xpath("//android.view.View[@content-desc='" + ec + "']"),"content-desc",3);
            System.out.println("\n\n\n" + ecChat + "\n\n\n");
            if (ecChat.equals(ec)) {
                escreverMensagen("1");
                enviar();
            } else {
                escreverMensagen("2");
                enviar();
            }
        } catch (TimeoutException | InterruptedException e) {
            retonarOEstadoInicial();
        }

    }

    public static void informarAdicionais(String texto) {
        escreverMensagen(texto);
        enviar();
    }

    public static void validandoMensagemTexto(String msg) {
        String textView = getDriver().findElement(By.xpath("//android.view.View[@content-desc='https://minhaconta2.cielo.com.br/minha-conta/centralAjuda']")).getAttribute("content-desc");
        Assert.assertEquals(msg, textView);
    }

    public static void opcoesDoMenu(String opcao) throws InterruptedException {
        switch (opcao) {
            case "1":
            case "1:Sim":
            case "1:Quero ser Cliente":
            case "1:Fiz o login":
            case "1-Vendas do dia":
            case "1:4 últimos dígitos do seu cartão":
            case "1-Resumo por dia da compra":
            case "1-Consultar nova data":
            case "1-Valor da Venda":
            case "1:FALAR COM ATENDENTE":
            case "1:PELICULA ACESSIBILIDADE ICMP":
            case "1:BOBINA UNIFICADA":
            case "1:BOBINA":
            case "1:Prazos de recebimento":
            case "1:Continuar falando sobre taxas e planos":
            case "1:Consultar por período":
            case "1:Detalhar por tipo de lançamento":
            case "1:SOROCRED":
                MobileActions.waitExplicitly(10);
                escreverMensagen("1");
                enviar();
                break;
            case "2":
            case "2:Não":
            case "2:Falar sobre máquina Cielo":
            case "2:Consultar por período":
            case "2:Preciso de ajuda com login":
            case "2-Vendas de outros periodos":
            case "2 - NSU - Número Sequencial Único":
            case "2-Resumo por forma de pagamento":
            case "2-Consultar Vendas canceladas":
            case "2-Número Sequencial Únco(NSU/Doc)":
            case "2:Valores de aluguel":
            case "2:Falar sobre outro assunto":
            case "2-ELO":
                MobileActions.waitExplicitly(10);
                escreverMensagen("2");
                enviar();
                break;
            case "3":
            case "3:Solicitação de materiais(Suprimentos)":
            case "3:Voltar ao menu":
            case "3-Extrato de recebíveis":
            case "3 - Não tenho nenhuma desta Informações":
            case "3-Informações detalhadas":
            case "3-Consultar falando sobre consulta de vendas e informações finaceiras":
            case "3-Não tenho nenhuma destas informações":
            case "3:NÃO ESTÁ LISTADO":
            case "3:PELÍCULA":
            case "3:Falar com atendente":
            case "3:Taxas contradas":
                MobileActions.waitExplicitly(10);
                escreverMensagen("3");
                enviar();
                break;
            case "4":
            case "4:Taxas e planos":
            case "4-Vendas Canceladas":
            case "4-Encerrar":
            case "4:Encerrar atendimento":
            case "4-Não desejo masi informações":
            case "4-Falar sobre outro assunto":
                MobileActions.waitExplicitly(10);
                escreverMensagen("4");
                enviar();
                break;
            case "5":
            case "5:Consultar vendas ou informações financeiras":
            case "5-Solicitar Declaração para Importo de Renda (DIRIF)":
            case "5 - Encerrar atendimento":
            case "5:Encerrar atendimento":
                MobileActions.waitExplicitly(10);
                escreverMensagen("5");
                enviar();
                break;
            case "6":
            case "6:Meu Cadastro":
            case "6-Falar sobre outro assunto":
                MobileActions.waitExplicitly(10);
                escreverMensagen("6");
                enviar();
                break;
            default:
                System.out.println("Opção" + opcao + "não encontrada no menu principal");
                break;

        }

    }
}
