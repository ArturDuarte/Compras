package br.com.analize.compras;

import br.com.analize.compras.entity.Categoria;
import br.com.analize.compras.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ComprasApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public static void main(String[] args) {
        SpringApplication.run(ComprasApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        List<Categoria> categorias = new ArrayList<>();
        Categoria categoria1 = new Categoria();
        categoria1.setId(1);
        categoria1.setNome("pecas");

        Categoria categoria2 = new Categoria();
        categoria2.setId(2);
        categoria2.setNome("Alimento");

        categorias.add(categoria1);
        categorias.add(categoria2);

        categoriaRepository.save(categorias);
    }
}
