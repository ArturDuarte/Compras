package br.com.analize.compras.resource;


import br.com.analize.compras.entity.Categoria;
import br.com.analize.compras.entity.Produto;
import br.com.analize.compras.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping(value = "/produtos")
@CrossOrigin("http://localhost:8080")
public class ProdutoResource {

    @Autowired
    private ProdutoService produtoService;
    //endpoint
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<Produto> buscarProduto(@PathVariable("id") Integer id) {
        Produto produto = produtoService.buscarProdutoPorId(id);
        return ResponseEntity.ok().body(produto);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insertProduto(@RequestBody Produto produto){
        produto = produtoService.insertProduto(produto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    //faz a atualização conforme o id passado
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> atualizaProduto(@RequestBody Produto produto, @PathVariable("id") Integer id) {
        produto.setId(id);
        produto = produtoService.atualizaProduto(produto);
        return  ResponseEntity.noContent().build();
    }




}
