package br.com.analize.compras.repository;

import br.com.analize.compras.entity.Cidade;
import br.com.analize.compras.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {


}
