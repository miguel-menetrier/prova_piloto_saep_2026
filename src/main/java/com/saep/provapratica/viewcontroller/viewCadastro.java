package com.saep.provapratica.viewcontroller;

import com.saep.provapratica.dto.UsuarioRequisicaoDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class viewCadastro {

    @GetMapping("/cadastro")
    public String viewCadastrousuario(Model model) {

        model.addAttribute("dataAtual", LocalDate.now());
        model.addAttribute("usuarioDto", new UsuarioRequisicaoDto());

        System.out.println("ok");
        return "cadastro";
    }
}
