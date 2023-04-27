package com.example.selenium.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageCep {
    private ChromeDriver chrome;
    private WebElement campoCep;

    public HomePageCep(ChromeDriver chrome) {
        this.chrome = chrome;
    }

    public WebElement obterBotaoCampoCep() {
        return chrome.findElement(By.xpath(
                "/html/body/app-root/div[1]/app-new-header/div[1]/div/div/nav/div[1]/div[3]/div[1]/app-user-location/div[1]/div[1]/span"));
    }

    public WebElement obterInputCep() {
        return chrome.findElement(By.xpath(
                "/html/body/ngb-modal-window/div/div/div[2]/app-new-my-addresses-v2/div[1]/div/div[1]/form/div/div[1]/div/label/input"));
    }

    public WebElement obterBotaoSalvarCep() {
        return chrome.findElement(By.xpath(
                "/html/body/ngb-modal-window/div/div/div[2]/app-new-my-addresses-v2/div[1]/div/div[1]/form/div/div[1]/div/div/button"));
    }

    public void clicarNoBotaoCep() {
        obterBotaoCampoCep().click();
    }

    public void preencherCampoCep(String cep) {
        campoCep = obterInputCep();
        campoCep.clear();
        campoCep.sendKeys(cep);
    }

    public void clicarNoBotaoSalvarCep() {
        obterBotaoSalvarCep().click();
    }

    public String obterCampoMenssagemDoCepInvalido() {
        return chrome.findElement(By.xpath(
                "/html/body/ngb-modal-window/div/div/div[2]/app-new-my-addresses-v2/div[1]/div/div[1]/form/div/div[1]/div/label/div"))
                .getText();
    }

    public String obterCampoCepString() {
        return chrome.findElement(By.xpath(
                "/html/body/app-root/div[1]/app-new-header/div[1]/div/div/nav/div[1]/div[3]/div[1]/app-user-location/div[1]/div[2]/div/p"))
                .getText();
    }

    public void tempoDeEspera(Long time) {
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }
}
