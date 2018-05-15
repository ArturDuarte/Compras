package br.com.analize.compras.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*Checklist para criar entidades
*  Atributos basicos
*  Associacoes (inicie as colecoes)
*  Construtores (nao inclua colecoes no construtor com parametros)
*  Getters e setters
*  hashCode e equals )implementacao padrao: somente id)
*  Serializable(padrao: 1L)
*/

@Entity
@Table(name = "tb_categoria")
@SequenceGenerator(name = "seq_categoria", sequenceName = "seq_categoria")
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_categoria")
    @Column(name = "ca_id")
    private Integer id;

    @Column(name = "ca_nome")
    private String nome;

    //Associações
    @ManyToMany(mappedBy = "categorias")
    List<Produto> produtos = new ArrayList<>();

    public Categoria() {

    }

    public Categoria(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
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

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(id, categoria.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}