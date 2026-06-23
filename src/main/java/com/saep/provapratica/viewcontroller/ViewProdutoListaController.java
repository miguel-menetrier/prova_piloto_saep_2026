package com.saep.provapratica.viewcontroller;

import com.saep.provapratica.dto.ProdutoRespostaDto;
import com.saep.provapratica.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ViewProdutoListaController {
    private final ProdutoService produtoService;

    @PreAuthorize("hasAuthority('OPERADOR')")
    @GetMapping("/produtolista")
    public String listaProduto(Model model) {
        List<ProdutoRespostaDto> produtoLista = produtoService.listaProdutos();
        model.addAttribute("produtoLista", produtoLista);
        return "produtolista";
    }
}
