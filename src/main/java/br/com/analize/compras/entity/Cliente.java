package br.com.analize.compras.entity;

import br.com.analize.compras.entity.enumeration.TipoClienteEnum;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name ="tb_cliente")
@SequenceGenerator(name = "seq_cliente", sequenceName = "seq_cliente")
public class Cliente implements Serializable {

    @Id
    @Column(name = "cl_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_cliente")
    private Integer id;

    @Column(name = "cl_nome")
    private String nome;

    @Column(name = "cl_email")
    private String email;

    @Column(name = "cl_cpf_cnpj")
    private String cpfOuCnpj;

    @Column(name = "cl_tipoCliente")
    private TipoClienteEnum tifpoCliente;

    @ElementCollection
    @CollectionTable(name = "tb_telefone", joinColumns = @JoinColumn(name = "cl_id"))
    private Set<String> telefones = new HashSet<>();

    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos = new ArrayList<>();

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos = new ArrayList<>();

    private Cliente(){

    }
    public Cliente(Integer id, String nome, String email, String cpfOuCnpj, TipoClienteEnum tifpoCliente) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.tifpoCliente = tifpoCliente;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public TipoClienteEnum getTifpoCliente() {
        return tifpoCliente;
    }

    public void setTifpoCliente(TipoClienteEnum tifpoCliente) {
        this.tifpoCliente = tifpoCliente;
    }

    public Set<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<String> telefones) {
        this.telefones = telefones;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
