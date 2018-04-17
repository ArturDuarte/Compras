package br.com.analize.compras.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "TB_CIDADE")
// Cria uma sequencia do id da tabela Categoria
@SequenceGenerator(name = "seq_cidade", sequenceName = "seq_cidade")
public class Cidade implements Serializable {

    @Id
    //Gera no banco um comando de auto increment usando a Sequence criada a cima
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_cidade")

    @Column(name = "CI_ID")
    private Integer id;

    @Column(name = "CI_NOME")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "ES_ID")
    private Estado estado;

    public Cidade() {
    }

    public Cidade(Integer id, String nome, Estado estado) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cidade cidade = (Cidade) o;
        return Objects.equals(id, cidade.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
