package br.com.santander.catalogo.repository;

import br.com.santander.catalogo.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,  Integer> {
}
