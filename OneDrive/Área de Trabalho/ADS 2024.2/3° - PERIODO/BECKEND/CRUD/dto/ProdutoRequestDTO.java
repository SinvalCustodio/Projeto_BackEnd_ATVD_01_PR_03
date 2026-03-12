package com.example.marketplace.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

/**
 * DTO para receber dados de produto em requisições POST/PUT.
 */
public class ProdutoRequestDTO {

    @NotBlank(message = "Nome do produto é obrigatório")
    private String nome;

    @NotBlank(message = "Descrição do produto é obrigatória")
    private String descricao;

    @NotNull(message = "Preço é obrigatório")
    @Positive(message = "O preço deve ser maior que zero")
    private BigDecimal preco;

    @NotNull(message = "Quantidade em estoque é obrigatória")
    @PositiveOrZero(message = "A quantidade não pode ser negativa")
    private Integer quantidadeEstoque;

    @NotNull(message = "ID do vendedor é obrigatório")
    @Positive(message = "O ID do vendedor deve ser válido")
    private Long vendedorId;

    // Construtores
    public ProdutoRequestDTO() {}

    public ProdutoRequestDTO(String nome, String descricao, BigDecimal preco, 
                            Integer quantidadeEstoque, Long vendedorId) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.vendedorId = vendedorId;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }

    public Integer getQuantidadeEstoque() { return quantidadeEstoque; }
    public void setQuantidadeEstoque(Integer quantidadeEstoque) { this.quantidadeEstoque = quantidadeEstoque; }

    public Long getVendedorId() { return vendedorId; }
    public void setVendedorId(Long vendedorId) { this.vendedorId = vendedorId; }
}
