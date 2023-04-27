package com.ada.testesautomatizados.projetotestesselenium.testes;

import com.ada.testesautomatizados.projetotestesselenium.pages.HomePageCep;
import com.ada.testesautomatizados.projetotestesselenium.setup.Pagina;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HomePageCepTest {

    private Pagina pagina = new Pagina();
    private HomePageCep tela;

    @Test
    void clicarNoCampoCepEPreencher() {

        tela = new HomePageCep(pagina.acessarPagina("https://www.fastshop.com.br/web/"));

        tela.clicarNoBotaoCep();
        tela.tempoDeEspera(10l);
        tela.preencherCampoCep("12345678");

    }

    @Test
    void clicarNoCampoCepEPreencherComDadoInvalido() {
        tela = new HomePageCep(pagina.acessarPagina("https://www.fastshop.com.br/web/"));

        tela.clicarNoBotaoCep();
        tela.tempoDeEspera(10l);
        tela.preencherCampoCep("12345678");
        tela.clicarNoBotaoSalvarCep();

        Assertions.assertEquals(tela.obterCampoMenssagemDoCepInvalido(), "CEP não localizado.");
    }

    @Test
    void clicarNoCampoCepEPreencherComDadoValido() {
        tela = new HomePageCep(pagina.acessarPagina("https://www.fastshop.com.br/web/"));

        tela.clicarNoBotaoCep();
        tela.tempoDeEspera(10l);
        tela.preencherCampoCep("30550590");
        tela.clicarNoBotaoSalvarCep();

        Assertions.assertEquals(tela.obterCampoCepString(), "30550-590");

    }
}
