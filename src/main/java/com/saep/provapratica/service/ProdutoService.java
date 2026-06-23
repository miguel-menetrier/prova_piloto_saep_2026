package com.saep.provapratica.service;

import com.saep.provapratica.dto.ProdutoRequisicaoDto;
import com.saep.provapratica.dto.ProdutoRespostaDto;
import com.saep.provapratica.model.ProdutoModel;
import com.saep.provapratica.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public boolean cadastrarProduto(ProdutoRequisicaoDto produtoRequisicaoDto) {
        ProdutoModel produtoModel = new ProdutoModel();

        produtoModel.setNome(produtoRequisicaoDto.getNome());
        produtoModel.setValor(produtoRequisicaoDto.getValor());
        produtoModel.setEstoque(produtoRequisicaoDto.getEstoque());

        produtoRepository.save(produtoModel);

        return true;
    }

    public List<ProdutoRespostaDto> listaProdutos() {
        List<ProdutoModel> listaProdutoModels = produtoRepository.findAll();
        List<ProdutoRespostaDto> listaProdutoDto = new ArrayList<>();

        for (ProdutoModel produto : listaProdutoModels) {
            listaProdutoDto.add(new ProdutoRespostaDto(produto));
        }
        return listaProdutoDto;
    }

    public boolean atualizarProduto(int id, ProdutoRequisicaoDto produtoRequisicaoDTO) {

        Optional<ProdutoModel> produtoOptional = produtoRepository.findById(id);
        ProdutoModel produtoModel = produtoOptional.get();

        int estoqueAtual = produtoModel.getEstoque();
        if (estoqueAtual < produtoRequisicaoDTO.getEstoque()){
            return false;
        }

        produtoModel.setEstoque(produtoRequisicaoDTO.getEstoque());
        produtoModel.setValor(produtoRequisicaoDTO.getValor());


        produtoRepository.save(produtoModel);
        return true;
    }


    public boolean deletarProduto(int id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public ProdutoRespostaDto buscarProdutoById(int id) {
        Optional<ProdutoModel> produto = produtoRepository.findById(id);

        return new ProdutoRespostaDto(produto.get());
    }
}
