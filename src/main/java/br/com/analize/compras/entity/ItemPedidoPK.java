package br.com.analize.compras.entity;

import br.com.analize.compras.entity.Pedido;
import br.com.analize.compras.entity.Produto;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

// Embeddable porque ele e um subItem
@Embeddable
public class ItemPedidoPK implements Serializable{

    @ManyToOne
    @JoinColumn(name = "pr_id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "pe_id")
    private Pedido pedido;

    public ItemPedidoPK() {

    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
