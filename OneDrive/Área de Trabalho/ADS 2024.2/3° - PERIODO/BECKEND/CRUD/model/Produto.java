package com.example.marketplace.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 * Representa um produto anunciado no marketplace.
 */
@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único do produto

    @Column(nullable = false, length = 200)
    private String nome; // Nome do produto

    @Column(length = 1000)
    private String descricao; // Descrição detalhada

    @Column(nullable = false, precision = 10, scale = 2) // Preço com 2 casas decimais
    private BigDecimal preco; // Preço do produto

    @Column(nullable = false)
    private Integer quantidadeEstoque; // Quantidade disponível

    // Muitos produtos pertencem a um único vendedor (usuário)
    @ManyToOne
    @JoinColumn(name = "vendedor_id", nullable = false) // Chave estrangeira para a tabela usuarios
    private Usuario vendedor; // Vendedor que anunciou o produto

    // Construtor padrão
    public Produto() {}

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }

    public Integer getQuantidadeEstoque() { return quantidadeEstoque; }
    public void setQuantidadeEstoque(Integer quantidadeEstoque) { this.quantidadeEstoque = quantidadeEstoque; }

    public Usuario getVendedor() { return vendedor; }
    public void setVendedor(Usuario vendedor) { this.vendedor = vendedor; }
}