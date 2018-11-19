package br.com.analize.compras.service;

import br.com.analize.compras.entity.Categoria;
import br.com.analize.compras.entity.Cliente;
import br.com.analize.compras.exception.DataIntegrityException;
import br.com.analize.compras.exception.ObjectNotFountException;
import br.com.analize.compras.repository.CategoriaRepository;
import br.com.analize.compras.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente buscarClientePorId(Integer id){

        //return clienteRepository.findOne(id);
        Cliente cliente = clienteRepository.findOne(id);

        if(cliente == null){
            throw new ObjectNotFountException("o objeto" + Cliente.class.getName() + "com ID: " + id + "nao foi encontrado");
        }
        return cliente;
    }

    // metodo insert
    public Cliente insertCliente(Cliente cliente){
        // garante que o abjeto é nulo assim a referencia que o objeto é novo e não uma atualização
        cliente.setId(null);
        return clienteRepository.save(cliente);
    }

    //metodo update
    public Cliente atualizaCliente(Cliente cliente) {
        //caso o id não exista dispara a execao do metodo buscar
        buscarClientePorId(cliente.getId());
        return clienteRepository.save(cliente);
    }

//metodo delete
    public void deletaCliente(Integer id) {
        try {
            //caso o id não exista dispara a execao do metodo buscar
            buscarClientePorId(id);
            clienteRepository.delete(id);
        }catch (DataIntegrityViolationException e) {
            // se o cliente for deletada incorretamente dispara uma exceção
            throw new DataIntegrityException("Você não pode deletar o cliente com pedidos");
        }

    }
}
