package br.com.analize.compras.repository;

import br.com.analize.compras.entity.Categoria;
import br.com.analize.compras.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {


}
