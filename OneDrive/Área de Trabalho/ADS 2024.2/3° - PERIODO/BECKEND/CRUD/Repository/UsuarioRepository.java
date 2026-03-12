package com.example.marketplace.repository;

import com.example.marketplace.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Busca usuário por e-mail (útil para autenticação)
    Optional<Usuario> findByEmail(String email);
}