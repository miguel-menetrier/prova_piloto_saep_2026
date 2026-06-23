package com.saep.provapratica.viewcontroller;

import com.saep.provapratica.dto.ProdutoRequisicaoDto;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewProdutoCadastroController {
    @PreAuthorize("hasAuthority('OPERADOR')")
    @GetMapping("/produtocadastro")
    public String viewCadastroProduto(Model model) {
        model.addAttribute("produtoDto", new ProdutoRequisicaoDto());
        return "produtocadastro";
    }
}
