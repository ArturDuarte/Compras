package br.com.analize.compras.service;

import br.com.analize.compras.entity.Categoria;
import br.com.analize.compras.entity.Pedido;
import br.com.analize.compras.exception.ObjectNotFountException;
import br.com.analize.compras.repository.CategoriaRepository;
import br.com.analize.compras.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido buscarPedidoPorId(Integer id){

        //return categoriaRepository.findOne(id);
        Pedido pedido = pedidoRepository.findOne(id);

        if(pedido == null){
            throw new ObjectNotFountException("o objeto" + Pedido.class.getName() + "com ID: " + id + "nao foi encontrado");
        }
        return pedido;
    }
}
