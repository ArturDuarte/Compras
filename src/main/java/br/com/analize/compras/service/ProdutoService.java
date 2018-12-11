package br.com.analize.compras.service;




import br.com.analize.compras.entity.Categoria;
import br.com.analize.compras.entity.Produto;
import br.com.analize.compras.exception.DataIntegrityException;
import br.com.analize.compras.exception.ObjectNotFountException;
import br.com.analize.compras.repository.CategoriaRepository;
import br.com.analize.compras.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Produto buscarProdutoPorId(Integer id){

        //return produtoRepository.findOne(id);
        Produto produto = produtoRepository.findOne(id);

        if(produto == null){
            throw new ObjectNotFountException("o objeto" + Produto.class.getName() + "com ID: " + id + "nao foi encontrado");
        }
        return produto;
    }

    // metodo insert
    public Produto insertProduto(Produto produto, Integer idCategoria){
        Categoria categoria = categoriaRepository.findOne(idCategoria);
        produto.getCategorias().add(categoria);
        // garante que o abjeto é nulo assim a referencia que o objeto é novo e não uma atualização
        produto.setId(null);
        return produtoRepository.save(produto);
    }

    //metodo update
    public Produto atualizaProduto(Produto produto) {
        //caso o id não exista dispara a execao do metodo buscar
        buscarProdutoPorId(produto.getId());
        return produtoRepository.save(produto);
    }

    // metodo delete
    // quando a categoria conter produtos devera não ser deletada
    public void deletaProduto(Integer id) {
        try {
            //caso o id não exista dispara a execao do metodo buscar
            buscarProdutoPorId(id);
            produtoRepository.delete(id);
        }catch (DataIntegrityViolationException e) {
            // se a categoria for deletada incorretamente dispara uma exceção
            throw new DataIntegrityException("Você não pode deletar uma categoria com produtos");
        }
    }

    public List<Produto> listaProdutos() {

        return produtoRepository.findAll();
    }

    public Page<Produto> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
        return produtoRepository.findAll(pageRequest);
    }
}
