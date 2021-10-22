package br.com.santander.catalogo.model.dto;

import br.com.santander.catalogo.model.Catalogo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CatalogoDto {

	private Integer id;
	private List<CategoriaDto> categorias = new ArrayList<>();
	private List<ProdutoDto>  produtos = new ArrayList<>();

	public CatalogoDto(Integer id,  List<CategoriaDto> categorias, List<ProdutoDto> produtos) {
		this.id = id;
		this.categorias = categorias;
		this.produtos = produtos;
	}

	public Integer getId() {
		return id;
	}

	public List<CategoriaDto> getCategorias() {
		return categorias;
	}

	public List<ProdutoDto> getProdutos() {
		return produtos;
	}

	public static CatalogoDto converte(Catalogo catalogo) {
		return new CatalogoDto(catalogo.getId(),
				catalogo.getCategorias().stream()
						.map(CategoriaDto::converte)
						.collect(Collectors.toList()),
				catalogo.getProdutos().stream()
						.map(ProdutoDto::converte)
						.collect(Collectors.toList()));
	}
}
