package br.com.santander.catalogo.controller;


import br.com.santander.catalogo.model.Catalogo;
import br.com.santander.catalogo.model.dto.CatalogoDto;
import br.com.santander.catalogo.service.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/catalogo")
//@ApiOperation(value = "Método para verificar catalogos.")
public class CatalogoController {

    CatalogoService catalogoService;

    @Autowired
    public CatalogoController(CatalogoService catalogoService) {
        this.catalogoService = catalogoService;
    }


    @GetMapping
    public ResponseEntity<List<Catalogo>> todosCatalogos(){
        return ResponseEntity.ok(catalogoService.buscaCatalogos());
    }

    @PostMapping
    public ResponseEntity<CatalogoDto> salvaCatalogo(@RequestBody Catalogo catalogo)  {
        Catalogo retContato = catalogoService.salvaCatalogo(catalogo);

        if (retContato != null){
            CatalogoDto retorno = CatalogoDto.converte(retContato);
            URI uri = UriComponentsBuilder.fromPath("contato/{id}").buildAndExpand(catalogo.getId()).toUri();
            return ResponseEntity.created(uri).body(retorno);
        }else{
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping
    public ResponseEntity<CatalogoDto> alteraCatalogo(@RequestBody Catalogo catalogo)  {
        Catalogo retCatalogo = catalogoService.alteraCatalogo(catalogo);

        if (retCatalogo != null){
            CatalogoDto retorno = CatalogoDto.converte(retCatalogo);
            return ResponseEntity.ok(retorno);
        }else{
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CatalogoDto> deletaCatalogo(@PathVariable Integer id)  {
        catalogoService.deletaCatalogo(id);
        return ResponseEntity.noContent().build();
    }
}
