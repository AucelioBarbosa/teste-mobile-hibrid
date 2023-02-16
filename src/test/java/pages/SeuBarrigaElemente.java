package pages;

import org.openqa.selenium.By;
import utils.StartDriver;

public class SeuBarrigaElemente extends StartDriver {
    public static By app = By.xpath("//*[@content-desc='CtAppium']");
    public static By CelularHibrid = By.xpath("//*[@text='SeuBarriga Híbrido']");
    public static By campoEmail = By.xpath("//*[@resource-id='email']");
    public static By campoSenha = By.xpath("//*[@resource-id='senha']");
    public static By btnEntrar = By.xpath("//*[@text='Entrar']");

    public static By menuHome = By.xpath("//*[@content-desc='Home']");
    public static By menuMobimentacao = By.xpath("//*[@content-desc='Criar Movimentação']");
    public static By menuContas = By.xpath("//*[@content-desc='Contas']");
    public static By menuResumoMensal = By.xpath("//*[@content-desc='Resumo Mensal']");
    public static By menuSair = By.xpath("//*[@content-desc='Sair']");



}
