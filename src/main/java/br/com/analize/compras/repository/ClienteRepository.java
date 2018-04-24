package br.com.analize.compras.repository;

import br.com.analize.compras.entity.Cidade;
import br.com.analize.compras.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {


}
