package com.example.marketplace.service;

import com.example.marketplace.dto.UsuarioRequestDTO;
import com.example.marketplace.dto.UsuarioResponseDTO;
import com.example.marketplace.exception.ResourceNotFoundException;
import com.example.marketplace.model.Usuario;
import com.example.marketplace.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private UsuarioResponseDTO toResponseDTO(Usuario usuario) {
        return new UsuarioResponseDTO(usuario.getId(), usuario.getNome(), usuario.getEmail());
    }

    @Transactional(readOnly = true)
    public List<UsuarioResponseDTO> listarTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public UsuarioResponseDTO buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com ID: " + id));
        return toResponseDTO(usuario);
    }

    @Transactional
    public UsuarioResponseDTO criar(UsuarioRequestDTO requestDTO) {
        // Verifica se e-mail já está em uso
        if (usuarioRepository.findByEmail(requestDTO.getEmail()).isPresent()) {
            throw new IllegalArgumentException("E-mail já cadastrado");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(requestDTO.getNome());
        usuario.setEmail(requestDTO.getEmail());
        usuario.setSenha(requestDTO.getSenha()); // Em produção, a senha deve ser codificada (ex: BCrypt)

        Usuario saved = usuarioRepository.save(usuario);
        return toResponseDTO(saved);
    }

    @Transactional
    public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO requestDTO) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com ID: " + id));

        // Se o e-mail for alterado, verifica se já existe
        if (!usuario.getEmail().equals(requestDTO.getEmail()) &&
                usuarioRepository.findByEmail(requestDTO.getEmail()).isPresent()) {
            throw new IllegalArgumentException("E-mail já cadastrado por outro usuário");
        }

        usuario.setNome(requestDTO.getNome());
        usuario.setEmail(requestDTO.getEmail());
        usuario.setSenha(requestDTO.getSenha());

        return toResponseDTO(usuario);
    }

    @Transactional
    public void excluir(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Usuário não encontrado com ID: " + id);
        }
        usuarioRepository.deleteById(id);
    }
}