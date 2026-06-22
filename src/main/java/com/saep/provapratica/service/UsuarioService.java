package com.saep.provapratica.service;

import com.saep.provapratica.dto.UsuarioRequisicaoDto;
import com.saep.provapratica.model.UsuarioModel;
import com.saep.provapratica.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public boolean cadastrarUsuario(UsuarioRequisicaoDto dados) {

        UsuarioModel usuarioModel = new UsuarioModel();

        usuarioModel.setNome(dados.getNome());
        usuarioModel.setSenha(encoder.encode(dados.getSenha()));
        usuarioModel.setEmail(dados.getEmail());
        usuarioModel.setCargo(dados.getCargo());

        usuarioRepository.save(usuarioModel);
        System.out.println("Cadastrado");
        return true;
    }

}
