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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<?> buscarCliente(@PathVariable("id") Integer id) {
        Cliente cliente = clienteService.buscarClientePorId(id);
        return ResponseEntity.ok().body(cliente);
    }
}
