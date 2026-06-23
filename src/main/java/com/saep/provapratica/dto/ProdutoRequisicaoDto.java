package com.saep.provapratica.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoRequisicaoDto {


    String nome;

    int estoque;

    BigDecimal valor;


}
