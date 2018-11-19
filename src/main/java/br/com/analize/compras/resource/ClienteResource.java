package br.com.analize.compras.resource;

//Classe de controle que ira fazer os GETs pegando o objeto todo ou apenas
//um determinado conteudo com o id

import br.com.analize.compras.entity.Categoria;
import br.com.analize.compras.entity.Cliente;
import br.com.analize.compras.service.CategoriaService;
import br.com.analize.compras.service.ClienteService;
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
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<Cliente> buscarCliente(@PathVariable("id") Integer id) {
        Cliente cliente = clienteService.buscarClientePorId(id);
        return ResponseEntity.ok().body(cliente);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insertCliente(@RequestBody Cliente cliente){
        cliente = clienteService.insertCliente(cliente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    //faz a atualização conforme o id passado
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> atualizaCliente(@RequestBody Cliente cliente, @PathVariable("id") Integer id) {
        cliente.setId(id);
        cliente = clienteService.atualizaCliente(cliente);
        return  ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<Cliente> deletaCliente(@PathVariable("id") Integer id) {
        clienteService.deletaCliente(id);
        return ResponseEntity.noContent().build();
    }


}
