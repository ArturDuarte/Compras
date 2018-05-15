package br.com.analize.compras.repository;

import br.com.analize.compras.entity.Cliente;
import br.com.analize.compras.entity.enumeration.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {


}
