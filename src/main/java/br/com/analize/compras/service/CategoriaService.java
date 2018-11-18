package br.com.analize.compras.service;

import br.com.analize.compras.entity.Categoria;
import br.com.analize.compras.exception.DataIntegrityException;
import br.com.analize.compras.exception.ObjectNotFountException;
import br.com.analize.compras.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria buscarCategoriaPorId(Integer id){

        //return categoriaRepository.findOne(id);
        Categoria categoria = categoriaRepository.findOne(id);

        if(categoria == null){
            throw new ObjectNotFountException("o objeto" + Categoria.class.getName() + "com ID: " + id + "nao foi encontrado");
        }
        return categoria;
    }

// metodo insert
    public Categoria insertCategoria(Categoria categoria){
        // garante que o abjeto é nulo assim a referencia que o objeto é novo e não uma atualização
        categoria.setId(null);
        return categoriaRepository.save(categoria);
    }

//metodo update
    public Categoria atualizaCategoria(Categoria categoria) {
        //caso o id não exista dispara a execao do metodo buscar
        buscarCategoriaPorId(categoria.getId());
        return categoriaRepository.save(categoria);
    }
// metodo delete
    // quando a categoria conter produtos devera não ser deletada
    public void deletaCategoria(Integer id) {
        try {
            //caso o id não exista dispara a execao do metodo buscar
            buscarCategoriaPorId(id);
            categoriaRepository.delete(id);
        }catch (DataIntegrityViolationException e) {
            // se a categoria for deletada incorretamente dispara uma exceção
            throw new DataIntegrityException("Você não pode deletar uma categoria com produtos");
        }
    }

    public List<Categoria> listaCategorias() {
        return categoriaRepository.findAll();
    }

}
