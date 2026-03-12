package com.example.marketplace.dto;

import java.math.BigDecimal;

/**
 * DTO para enviar dados de produto nas respostas da API.
 */
public class ProdutoResponseDTO {

    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Integer quantidadeEstoque;
    private Long vendedorId;      // ID do vendedor
    private String vendedorNome;   // Nome do vendedor (opcional, para enriquecer a resposta)

    // Construtor que preenche os campos a partir da entidade Produto
    public ProdutoResponseDTO(Long id, String nome, String descricao, BigDecimal preco,
                              Integer quantidadeEstoque, Long vendedorId, String vendedorNome) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.vendedorId = vendedorId;
        this.vendedorNome = vendedorNome;
    }

    // Getters (necessários para serialização JSON)
    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public BigDecimal getPreco() { return preco; }
    public Integer getQuantidadeEstoque() { return quantidadeEstoque; }
    public Long getVendedorId() { return vendedorId; }
    public String getVendedorNome() { return vendedorNome; }
}