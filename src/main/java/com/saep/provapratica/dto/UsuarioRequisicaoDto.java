package com.saep.provapratica.dto;

import com.saep.provapratica.infra.Cargo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UsuarioRequisicaoDto {


    private String nome;

    @Email(message = "O campo de email deve ser válido")
    private String email;

    private Cargo cargo;

    private String senha;
}
