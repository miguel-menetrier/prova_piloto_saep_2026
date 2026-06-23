package com.saep.provapratica.viewcontroller;

import com.saep.provapratica.dto.ProdutoRespostaDto;
import com.saep.provapratica.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class ViewProdutoAtualizarController {
    private final ProdutoService produtoService;

    @PreAuthorize("hasAuthority('OPERADOR')")
    @GetMapping("/produtoatualizar/{id}")
    public String viewAtualizarProduto(@PathVariable int id, Model model) {
        ProdutoRespostaDto produtoDto = produtoService.buscarProdutoById(id);

        model.addAttribute("produtoDto", produtoDto);
        return "produtoatualizar";
    }
}
