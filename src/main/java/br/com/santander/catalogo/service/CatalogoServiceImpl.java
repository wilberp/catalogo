package br.com.santander.catalogo.service;

import br.com.santander.catalogo.model.Catalogo;
import br.com.santander.catalogo.repository.CatalogoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogoServiceImpl implements CatalogoService {

    CatalogoRepository catalogoRepository;

    public CatalogoServiceImpl(CatalogoRepository catalogoRepository) {
        this.catalogoRepository = catalogoRepository;
    }

    @Override
    public Catalogo buscaCatalogoPorId(Integer id){
        Catalogo ret = catalogoRepository.getById(id);
        return ret;
    }

    @Override
    public List<Catalogo> buscaCatalogos(){
        return catalogoRepository.findAll();
    }

    @Override
    public Catalogo salvaCatalogo(Catalogo contato) {

        if (contato!=null){
            return catalogoRepository.save(contato);
        }else{
            return null;
        }
    }

    @Override
    public Catalogo alteraCatalogo(Catalogo contato) {
        Catalogo retornoContato = catalogoRepository.getById(contato.getId());
        if (retornoContato != null) {
            return catalogoRepository.save(contato);
        }
        return retornoContato;
    }

    @Override
    public void deletaCatalogo(Integer id) {
        Catalogo retornoContato = catalogoRepository.getById(id);
        if (retornoContato != null) {
            catalogoRepository.deleteById(retornoContato.getId());
        }
    }
}
