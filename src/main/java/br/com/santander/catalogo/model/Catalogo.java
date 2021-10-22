package br.com.santander.catalogo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Catalogo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToMany(mappedBy = "catalogo", cascade = CascadeType.ALL)
	private List<Categoria> categorias = new ArrayList<>();

	@OneToMany(mappedBy = "catalogo", cascade = CascadeType.ALL)
	private List<Produto> produtos = new ArrayList<>();


	public Catalogo(List<Categoria> categorias, List<Produto> produtos ) {
		this.categorias = categorias;
		this.produtos = produtos;
	}

	protected Catalogo() {
	}

	public Integer getId() {return id;	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setCategorias(Collection<Categoria> categorias) {
		categorias.forEach(e -> adicionaCategoria(e));
	}

	public void adicionaCategoria(Categoria categoria) {
		categoria.setCatalogo(this);
		this.categorias.add(categoria);
	}


	public void setProdutos(Collection<Produto> produtos) {
		produtos.forEach(e -> adicionaProduto(e));
	}

	public void adicionaProduto(Produto produtos) {
		produtos.setCatalogo(this);
		this.produtos.add(produtos);
	}

	@Override
	public String toString() {
		return "Catalogo{" +
				"id=" + id +
				", categorias=" + categorias +
				", produtos=" + produtos +
				'}';
	}
}
