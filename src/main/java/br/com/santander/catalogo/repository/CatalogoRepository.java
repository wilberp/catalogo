package br.com.santander.catalogo.repository;

import br.com.santander.catalogo.model.Catalogo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogoRepository extends JpaRepository<Catalogo,  Integer> {
}
