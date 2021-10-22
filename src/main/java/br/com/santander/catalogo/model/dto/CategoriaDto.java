package br.com.santander.catalogo.model.dto;

import br.com.santander.catalogo.model.Categoria;

public class CategoriaDto {
    private Integer id;
    private String nome;
    private String descricao;

    public CategoriaDto(Integer id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public static CategoriaDto converte(Categoria retCategoria) {
        return new CategoriaDto(retCategoria.getId(), retCategoria.getNome(), retCategoria.getDescricao());
    }

}


