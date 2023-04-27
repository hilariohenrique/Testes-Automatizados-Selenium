package com.example.selenium.setup;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Pagina {
    public ChromeDriver acessarPagina(String path) {
        System.setProperty("webdriver.chrome.driver", "G:\\Meu Drive\\Cursos\\Americanas Polo Tech\\CT_Americanas\\Testes Automatizados\\testes-interface\\selenium-testes\\webDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver chrome = new ChromeDriver(options);
        chrome.get(path);
        return chrome;
    }
}
