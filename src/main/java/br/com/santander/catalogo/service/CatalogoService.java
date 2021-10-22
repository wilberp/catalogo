package br.com.santander.catalogo.service;


import br.com.santander.catalogo.model.Catalogo;

import java.util.List;

public interface CatalogoService {

    Catalogo buscaCatalogoPorId(Integer id);
    List<Catalogo> buscaCatalogos();
    Catalogo salvaCatalogo(Catalogo catalogo);
    Catalogo alteraCatalogo(Catalogo catalogo);
    void deletaCatalogo (Integer id);

}
