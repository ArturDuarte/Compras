package br.com.analize.compras.service;

import br.com.analize.compras.entity.Categoria;
import br.com.analize.compras.exception.ObjectNotFountException;
import br.com.analize.compras.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria buscarCategoriaPorID(Integer id){

        //return categoriaRepository.findOne(id);
        Categoria categoria = categoriaRepository.findOne(id);

        if(categoria == null){
            throw new ObjectNotFountException("o objeto" + Categoria.class.getName() + "com ID: " + id + "nao foi encontrado");
        }
        return categoria;
    }
}
