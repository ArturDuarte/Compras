package br.com.analize.compras;

import br.com.analize.compras.entity.Categoria;
import br.com.analize.compras.entity.Produto;
import br.com.analize.compras.repository.CategoriaRepository;
import br.com.analize.compras.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;


@SpringBootApplication
public class ComprasApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public static void main(String[] args) {
        SpringApplication.run(ComprasApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

        Categoria Cat1 = new Categoria(null, "informatica");
        Categoria Cat2 = new Categoria(null, "escritorio");

        Produto p1 = new Produto(null, "Computador", 2000.00);
        Produto p2 = new Produto(null, "Impressora", 800.00);
        Produto p3 = new Produto(null, "Mouse", 80.00);

        Cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        Cat2.getProdutos().addAll(Arrays.asList(p2));

        p1.getCategorias().addAll(Arrays.asList(Cat1));
        p2.getCategorias().addAll(Arrays.asList(Cat1, Cat2));
        p3.getCategorias().addAll(Arrays.asList(Cat1));

        categoriaRepository.save(Arrays.asList(Cat1, Cat2));
        produtoRepository.save(Arrays.asList(p1, p2, p3));
    }
}
