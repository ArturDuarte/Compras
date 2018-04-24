package br.com.analize.compras.entity.enumeration;

public enum TipoClienteEnum {

    PESSOAFISICA("pessoaFisica"),
    PESSOAJURIDICA("pessoaJuridica");

    String descricao;
    TipoClienteEnum(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
