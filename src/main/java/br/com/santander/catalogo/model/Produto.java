package br.com.santander.catalogo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomeProduto;
    @ManyToOne
    private Catalogo catalogo;

    protected Produto() {
    }

    public Integer getId() {
        return id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nomeProduto='" + nomeProduto + '\'' +
                ", catalogo=" + catalogo +
                '}';
    }
}


