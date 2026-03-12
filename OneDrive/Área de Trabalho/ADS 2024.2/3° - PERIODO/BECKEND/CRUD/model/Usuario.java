package com.example.marketplace.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa um usuário do marketplace (vendedor ou comprador).
 */
@Entity // Indica que esta classe é uma entidade JPA
@Table(name = "usuarios") // Define o nome da tabela no banco de dados
public class Usuario {

    @Id // Define a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera o valor automaticamente (auto-incremento)
    private Long id; // Identificador único do usuário

    @Column(nullable = false, length = 100) // Coluna não nula com tamanho máximo 100
    private String nome; // Nome completo do usuário

    @Column(nullable = false, unique = true, length = 150) // Único e não nulo
    private String email; // E-mail do usuário (utilizado para login)

    @Column(nullable = false) // Senha (em produção, deve ser armazenada com hash)
    private String senha;

    // Um usuário pode ter vários produtos (relacionamento um-para-muitos)
    @OneToMany(mappedBy = "vendedor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Produto> produtos = new ArrayList<>();

    // Construtor padrão exigido pelo JPA
    public Usuario() {}

    // Getters e Setters (comentados para brevidade, mas essenciais)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public List<Produto> getProdutos() { return produtos; }
    public void setProdutos(List<Produto> produtos) { this.produtos = produtos; }
}