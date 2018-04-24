package br.com.analize.compras.entity;

import br.com.analize.compras.entity.enumeration.EstadoPagamentoEnum;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "tb_pagamentoComBoleto")
public class PagamentoComBoleto extends Pagamento{

    private Date dataVencimento;
    private Date dataPagamento;

    public PagamentoComBoleto(){

    }
    public PagamentoComBoleto(Integer id, EstadoPagamentoEnum estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
        super(id, estado, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}
