package com.saep.provapratica.dto;

import com.saep.provapratica.model.ProdutoModel;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoRespostaDto {

    int id;

    String nome;

    int estoque;

    BigDecimal valor;

    public ProdutoRespostaDto(ProdutoModel produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.valor = produto.getValor();
        this.estoque = produto.getEstoque();
    }
}
