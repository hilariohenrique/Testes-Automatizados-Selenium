package com.ada.testesautomatizados.projetotestesselenium.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TelaDeLogin {
    private ChromeDriver chrome;
    private WebElement campoLogin;
    private WebElement campoSenha;

    // page object

    public TelaDeLogin(ChromeDriver chrome) {
        this.chrome = chrome;
        obterCampoLogin();
        obterCampoSenha();
    }

    public WebElement obterCampoLogin() {
        if (campoLogin == null) {
            campoLogin = chrome.findElement(By.xpath(
                    "/html/body/app-root/div/div[2]/app-new-login/div/div/div/div/div[2]/div/form/div[1]/label/input"));
        }
        return campoLogin;

    }

    public WebElement obterCampoSenha() {
        if (campoSenha == null) {
            campoSenha = chrome.findElement(By.xpath(
                    "html/body/app-root/div/div[2]/app-new-login/div/div/div/div/div[2]/div/form/webapp[1]/div/div/label/input"));
        }

        return campoSenha;
    }

    public WebElement obterBotao() {
        return chrome.findElement(
                By.xpath("/html/body/app-root/div/div[2]/app-new-login/div/div/div/div/div[2]/div/form/div[2]/button"));
    }

    public void clicarNoBotao() {
        obterBotao().click();
    }

    public void preencherCampoLogin(String login) {
        campoLogin.clear();
        campoLogin.sendKeys(login);
    }

    public void preencherCampoSenha(String senha) {
        campoSenha.clear();
        campoSenha.sendKeys(senha);
    }

    public String obterCampoValidoDeLogin() {

        return chrome.findElement(
                By.xpath(
                        "/html/body/app-root/div/div[2]/app-new-login/div/div/div/div/div[2]/div/form/div[1]/label/div"))
                .getText();
    }

    public String obterCampoMenssagemAoEfetuarLoginInvalido() {

        return chrome.findElement(
                By.xpath(
                        "/html/body/app-root/div/div[2]/app-new-login/div/div/div/div/div[2]/div/form/p"))
                .getText();
    }

    public void tempoDeEspera(Long time) {
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }

    public void fecharJanela() {
        chrome.close();
    }

}
