package com.example.marketplace.dto;

/**
 * DTO para enviar dados do usuário nas respostas da API.
 */
public class UsuarioResponseDTO {

    private Long id;
    private String nome;
    private String email;

    // Construtor padrão
    public UsuarioResponseDTO() {}

    // Construtor com parâmetros
    public UsuarioResponseDTO(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    // Getters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
