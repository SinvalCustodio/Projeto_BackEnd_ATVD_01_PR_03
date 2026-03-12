package com.example.marketplace.controller;

import com.example.marketplace.dto.ProdutoRequestDTO;
import com.example.marketplace.dto.ProdutoResponseDTO;
import com.example.marketplace.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para operações com produtos.
 */
@RestController
@RequestMapping("/api/produtos")
@Tag(name = "Produtos", description = "Endpoints para gerenciar produtos do marketplace")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    @Operation(summary = "Listar todos os produtos", description = "Retorna uma lista de todos os produtos cadastrados no marketplace")
    @ApiResponse(responseCode = "200", description = "Lista de produtos retornada com sucesso",
            content = @Content(schema = @Schema(implementation = ProdutoResponseDTO.class)))
    public ResponseEntity<List<ProdutoResponseDTO>> listarTodos() {
        List<ProdutoResponseDTO> produtos = produtoService.listarTodos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar produto por ID", description = "Retorna os dados de um produto específico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto encontrado",
                    content = @Content(schema = @Schema(implementation = ProdutoResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    public ResponseEntity<ProdutoResponseDTO> buscarPorId(
            @Parameter(description = "ID do produto a buscar", example = "1")
            @PathVariable Long id) {
        ProdutoResponseDTO produto = produtoService.buscarPorId(id);
        return ResponseEntity.ok(produto);
    }

    @PostMapping
    @Operation(summary = "Criar novo produto", description = "Cria um novo produto no marketplace")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Produto criado com sucesso",
                    content = @Content(schema = @Schema(implementation = ProdutoResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "404", description = "Vendedor não encontrado")
    })
    public ResponseEntity<ProdutoResponseDTO> criar(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Dados do produto a ser criado", required = true)
            @Valid @RequestBody ProdutoRequestDTO requestDTO) {
        ProdutoResponseDTO produto = produtoService.criar(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar produto", description = "Atualiza os dados de um produto existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso",
                    content = @Content(schema = @Schema(implementation = ProdutoResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Produto ou vendedor não encontrado"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    public ResponseEntity<ProdutoResponseDTO> atualizar(
            @Parameter(description = "ID do produto a atualizar", example = "1")
            @PathVariable Long id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Novos dados do produto", required = true)
            @Valid @RequestBody ProdutoRequestDTO requestDTO) {
        ProdutoResponseDTO produto = produtoService.atualizar(id, requestDTO);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar produto", description = "Remove um produto do marketplace")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Produto deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    public ResponseEntity<Void> excluir(
            @Parameter(description = "ID do produto a deletar", example = "1")
            @PathVariable Long id) {
        produtoService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/vendedor/{vendedorId}")
    @Operation(summary = "Listar produtos por vendedor", description = "Retorna todos os produtos de um vendedor específico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de produtos do vendedor retornada com sucesso",
                    content = @Content(schema = @Schema(implementation = ProdutoResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Vendedor não encontrado")
    })
    public ResponseEntity<List<ProdutoResponseDTO>> listarPorVendedor(
            @Parameter(description = "ID do vendedor", example = "1")
            @PathVariable Long vendedorId) {
        List<ProdutoResponseDTO> produtos = produtoService.listarPorVendedor(vendedorId);
        return ResponseEntity.ok(produtos);
    }
}