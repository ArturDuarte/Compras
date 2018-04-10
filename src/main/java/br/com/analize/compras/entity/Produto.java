package br.com.analize.compras.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import sun.swing.BakedArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "TB_PRODUTO")

// Cria uma sequencia do id da tabela Categoria
@SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto")

public class Produto implements Serializable {

    @Id
    //Gera no banco um comando de auto increment usando a Sequence criada a cima
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_produto")

    @Column(name = "PR_ID")
    private Integer id;

    @Column(name = "PR_NOME")
    private String nome;

    @Column(name = "PR_PRECO")
    private Double preco;

    //Associacoes
    @JsonBackReference
    @ManyToMany
    @JoinTable(name = "TB_PRODUTO_CATEGORIA",
            joinColumns = @JoinColumn(name = "PR_ID"),
            inverseJoinColumns = @JoinColumn(name = "CA_ID"))

    private List<Categoria> categorias = new ArrayList<>();

    public Produto(){

    }

    public Produto(Integer id, String nome, Double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
