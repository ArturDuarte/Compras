package br.com.analize.compras.entity.enumeration;

public enum EstadoPagamentoEnum {

    PENDENTE ("Pendente"),
    QUITADO ("Quitado"),
    CANCELADO ("Cancelado");

    String descricao;

    EstadoPagamentoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
