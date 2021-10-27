package br.com.santander.catalogo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String descricao;
	@ManyToOne
	private Catalogo catalogo;

	public Categoria(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}
	
	protected Categoria() {}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}

	@Override
	public String toString() {
		return "Categoria{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", descricao='" + descricao + '\'' +
				", catalogo=" + catalogo +
				'}';
	}
}
