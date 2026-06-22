package com.saep.provapratica.dto;

import com.saep.provapratica.infra.Cargo;
import lombok.Data;

@Data
public class UsuarioRespostaDto {

    int id;

    String nome;

    String email;

    String senha;

    Cargo cargo;

}
