package br.com.analize.compras.service;

import br.com.analize.compras.entity.Categoria;
import br.com.analize.compras.repository.CategoriaRepository;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria buscarCategoriaPorID(Integer id){

        return categoriaRepository.findOne(id);

    }
}
