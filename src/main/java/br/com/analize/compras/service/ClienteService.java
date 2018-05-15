package br.com.analize.compras.service;

import br.com.analize.compras.entity.Categoria;
import br.com.analize.compras.entity.Cliente;
import br.com.analize.compras.exception.ObjectNotFountException;
import br.com.analize.compras.repository.CategoriaRepository;
import br.com.analize.compras.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}
