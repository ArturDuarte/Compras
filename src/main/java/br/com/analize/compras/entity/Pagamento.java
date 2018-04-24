package br.com.analize.compras.entity;

import br.com.analize.compras.entity.enumeration.EstadoPagamentoEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name ="tb_pagamento")
@SequenceGenerator(name = "seq_pagamento", sequenceName = "seq_pagamento")
public class Pagamento {

    @Id
    @Column(name = "cl_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_pagamento")
    private Integer id;
    private EstadoPagamentoEnum estado;

    @OneToOne
    @JoinColumn(name = "pe_id")
    @MapsId     //a chave primaria de pedido 'e a chave primaria de pagamento
    private Pedido pedido;

    public Pagamento(){

    }

    public Pagamento(Integer id, EstadoPagamentoEnum estado, Pedido pedido) {
        this.id = id;
        this.estado = estado;
        this.pedido = pedido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EstadoPagamentoEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoPagamentoEnum estado) {
        this.estado = estado;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(id, pagamento.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
