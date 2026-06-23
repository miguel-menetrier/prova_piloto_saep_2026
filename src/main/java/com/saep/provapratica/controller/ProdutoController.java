package com.saep.provapratica.controller;

import com.saep.provapratica.dto.ProdutoRequisicaoDto;
import com.saep.provapratica.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ProdutoController {
    private final ProdutoService produtoService;

    @PostMapping("/produto")
    public String cadastrarProduto(@Valid @ModelAttribute("produtoDto") ProdutoRequisicaoDto produtoDto) {
        produtoService.cadastrarProduto(produtoDto);
        return "redirect:/produtolista";
    }

    @PostMapping("/produto/{id}")
    public String atualizarProduto(@Valid @ModelAttribute("produtoDto") ProdutoRequisicaoDto produtoDto,
                                   @PathVariable int id) {
        produtoService.atualizarProduto(id, produtoDto);
        return "redirect:/produtolista";
    }

    @DeleteMapping("/produto/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable int id) {
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
}
