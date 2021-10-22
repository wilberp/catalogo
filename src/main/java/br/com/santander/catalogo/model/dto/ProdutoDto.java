package br.com.santander.catalogo.model.dto;

import br.com.santander.catalogo.model.Produto;

public class ProdutoDto {

    private Integer id;
    private String nomeProduto;

    public ProdutoDto(Integer id, String nomeProduto) {
        this.id = id;
        this.nomeProduto = nomeProduto;
    }

    public Integer getId() {
        return id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public static ProdutoDto converte(Produto produto) {
        return new ProdutoDto(produto.getId(), produto.getNomeProduto());
    }

}
