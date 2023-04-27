package com.ada.testesautomatizados.projetotestesselenium.testes;

import com.ada.testesautomatizados.projetotestesselenium.pages.Busca;
import com.ada.testesautomatizados.projetotestesselenium.setup.Pagina;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class HomePageBuscaTest {

    Pagina pagina = new Pagina();
    private Busca tela;

    @Test
    void preencherCampoBuscaAndPesquisar() {
        tela = new Busca(pagina.acessarPagina("https://www.fastshop.com.br/web/"));

        tela.preencherCampoBuscaAndPesquisar("lenovo");
    }

    @Test
    void validarSeBuscaRealizadaTrasProdutosSolicitados() {
        tela = new Busca(pagina.acessarPagina("https://www.fastshop.com.br/web/"));

        String pesquisa = "lenovo";
        tela.preencherCampoBuscaAndPesquisar(pesquisa);

        tela.tempoDeEspera(10l);
        List<String> lista = tela.obterTextoDasTresPrimeirasPesquisas();

        Assertions.assertTrue(lista.get(0).toLowerCase().contains(pesquisa));
        Assertions.assertTrue(lista.get(1).toLowerCase().contains(pesquisa));
        Assertions.assertTrue(lista.get(2).toLowerCase().contains(pesquisa));
    }

    @Test
    void validarSePesquisaRealizadaNaBuscaRefleteAoQueFoiEscritoNaPagina() {
        tela = new Busca(pagina.acessarPagina("https://www.fastshop.com.br/web/"));

        String pesquisa = "lenovo";
        tela.preencherCampoBuscaAndPesquisar(pesquisa);

        tela.tempoDeEspera(10l);

        Assertions.assertEquals(tela.obterTextoDoResultadoDePesquisa(), pesquisa);

    }
}
