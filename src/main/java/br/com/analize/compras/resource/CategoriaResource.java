package br.com.analize.compras.resource;

//Classe de controle que ira fazer os GETs pegando o objeto todo ou apenas
//um determinado conteudo com o id

import br.com.analize.compras.entity.Categoria;
import br.com.analize.compras.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;
//endpoint
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<Categoria> buscarCategoria(@PathVariable("id") Integer id) {
        Categoria categoria = categoriaService.buscarCategoriaPorId(id);
        return ResponseEntity.ok().body(categoria);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insertCategoria(@RequestBody Categoria categoria){
        categoria = categoriaService.insertCategoria(categoria);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    //faz a atualização conforme o id passado
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> atualizaCategoria(@RequestBody Categoria categoria, @PathVariable("id") Integer id) {
        categoria.setId(id);
        categoria = categoriaService.atualizaCategoria(categoria);
        return  ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<Categoria> deletaCategoria(@PathVariable("id") Integer id) {
        categoriaService.deletaCategoria(id);
        return ResponseEntity.noContent().build();
    }

}
