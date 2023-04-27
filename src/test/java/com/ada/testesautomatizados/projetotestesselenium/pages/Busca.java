package com.ada.testesautomatizados.projetotestesselenium.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Busca {
    private ChromeDriver chrome;
    private WebElement campoBusca;

    public Busca(ChromeDriver chrome) {
        this.chrome = chrome;
        obterCampoBusca();
    }

    private WebElement obterCampoBusca() {

        if (campoBusca == null) {
            campoBusca = chrome.findElement(By.xpath(
                    "/html/body/app-root/div[1]/app-new-header/div[1]/div/div/nav/div[1]/div[1]/div[2]/app-new-search-box/div/div/input"));
        }

        return campoBusca;
    }

    public void preencherCampoBuscaAndPesquisar(String pesquisa) {
        campoBusca.sendKeys(pesquisa);
        campoBusca.sendKeys(Keys.ENTER);
    }

    public List<String> obterTextoDasTresPrimeirasPesquisas() {
        List<String> lista = new ArrayList<>();

        lista.add(chrome.findElement(By.xpath(
                "/html/body/app-root/div[1]/div[3]/app-search-page/div/div/div[2]/app-product-list/div/app-product-item[1]/div/a/div[3]/h3"))
                .getText());
        lista.add(chrome.findElement(By.xpath(
                "/html/body/app-root/div[1]/div[3]/app-search-page/div/div/div[2]/app-product-list/div/app-product-item[2]/div/a/div[3]/h3"))
                .getText());
        lista.add(chrome.findElement(By.xpath(
                "/html/body/app-root/div[1]/div[3]/app-search-page/div/div/div[2]/app-product-list/div/app-product-item[3]/div/a/div[3]/h3"))
                .getText());

        return lista;
    }

    public String obterTextoDoResultadoDePesquisa() {
        return chrome
                .findElement(
                        By.xpath("/html/body/app-root/div[1]/div[3]/app-search-page/div/div/div[2]/div[1]/h1/span"))
                .getText();
    }

    public void tempoDeEspera(Long time) {
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }
}
