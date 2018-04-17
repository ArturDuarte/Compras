package br.com.analize.compras;

import br.com.analize.compras.entity.Categoria;
import br.com.analize.compras.entity.Cidade;
import br.com.analize.compras.entity.Estado;
import br.com.analize.compras.entity.Produto;
import br.com.analize.compras.repository.CategoriaRepository;
import br.com.analize.compras.repository.CidadeRepository;
import br.com.analize.compras.repository.EstadoRepository;
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

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

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

        Estado est1 = new Estado(null, "Minas Gerais");
        Estado est2 = new Estado(null, "Sao Paulo");

        Cidade c1 = new Cidade(null, "Uberlandia", est1);
        Cidade c2 = new Cidade(null, "Sao Paulo", est2);
        Cidade c3 = new Cidade(null, "Campinas", est2);

        est1.getCidades().addAll(Arrays.asList(c1));
        est2.getCidades().addAll(Arrays.asList(c2,c3));

        c1.setEstado(est1);
        c2.setEstado(est2);
        c3.setEstado(est2);

        estadoRepository.save(Arrays.asList(est1, est2));
        cidadeRepository.save(Arrays.asList(c1, c2, c3));
    }
}
