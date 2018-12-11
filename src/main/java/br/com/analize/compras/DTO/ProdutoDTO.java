package br.com.analize.compras.DTO;

import br.com.analize.compras.entity.Categoria;

import java.io.Serializable;

public class ProdutoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

//    private Integer id;
//    private String nome;
    //mudando de id para value e de nome para text não precisa converter no front end

    private Integer value;
    private String text;
    private Double preco;

    public ProdutoDTO(Categoria cat){
       value = cat.getId();
       text = cat.getNome();

    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ProdutoDTO(){
    }


}
