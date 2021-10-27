package br.com.santander.catalogo.repository;

import br.com.santander.catalogo.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,  Integer> {
}
