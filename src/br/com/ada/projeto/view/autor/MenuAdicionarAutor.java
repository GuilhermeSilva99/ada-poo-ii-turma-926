package br.com.ada.projeto.view.autor;

import br.com.ada.projeto.business.GerenciadorDeAutor;
import br.com.ada.projeto.model.Autor;
import br.com.ada.projeto.view.CapturadorDeEntrada;
import br.com.ada.projeto.view.Submenu;

public class MenuAdicionarAutor extends Submenu {

    private final GerenciadorDeAutor gerenciadorDeAutor;


    public MenuAdicionarAutor(GerenciadorDeAutor gerenciadorDeAutor) {
        super("Adicionar " + GerenciadorDeAutor.AUTOR_DESCRICAO_CLASSE);
        this.gerenciadorDeAutor = gerenciadorDeAutor;
    }

    @Override
    public void acao() {
        String nome = CapturadorDeEntrada.capturarString("o nome");

        if (gerenciadorDeAutor.existeAutor(nome)) {
            System.out.println("Já existe um autor com esse nome");
            return;
        }

        String nacionalidade = CapturadorDeEntrada.capturarString("a nacionalidade");
        Autor autorAdicionado = gerenciadorDeAutor.adicionarAutor(nome, nacionalidade);

        System.out.println(GerenciadorDeAutor.AUTOR_DESCRICAO_CLASSE + " adicionado com sucesso");
        System.out.println(autorAdicionado);
    }
}
