package com.saep.provapratica.controller;

import com.saep.provapratica.dto.UsuarioRequisicaoDto;
import com.saep.provapratica.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping("/cadastro")
    public String cadastrarUsuario(@Valid @ModelAttribute("usuarioDto") UsuarioRequisicaoDto usuarioDto) {

        service.cadastrarUsuario(usuarioDto);


        return "redirect:/login?sucesso";

    }
}
