package br.com.analize.compras.entity;

import br.com.analize.compras.entity.enumeration.EstadoPagamentoEnum;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pagamentoComCartao")
public class PagamentoComCartao extends Pagamento{

    private  Integer numeroDeParcelas;

    public PagamentoComCartao(){

    }
    public PagamentoComCartao(Integer id, EstadoPagamentoEnum estado, Pedido pedido, Integer numeroDeParcelas) {
        super(id, estado, pedido);
        this.numeroDeParcelas = numeroDeParcelas;
    }

    public Integer getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    public void setNumeroDeParcelas(Integer numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }
}
