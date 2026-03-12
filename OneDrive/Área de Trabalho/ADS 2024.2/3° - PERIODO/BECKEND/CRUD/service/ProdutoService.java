package com.example.marketplace.service;

import com.example.marketplace.dto.ProdutoRequestDTO;
import com.example.marketplace.dto.ProdutoResponseDTO;
import com.example.marketplace.exception.ResourceNotFoundException;
import com.example.marketplace.model.Produto;
import com.example.marketplace.model.Usuario;
import com.example.marketplace.repository.ProdutoRepository;
import com.example.marketplace.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Serviço responsável pelas regras de negócio relacionadas a Produto.
 */
@Service // Indica que é um bean de serviço do Spring
public class ProdutoService {

    @Autowired // Injeta automaticamente o repositório
    private ProdutoRepository produtoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Converte uma entidade Produto em ProdutoResponseDTO.
     */
    private ProdutoResponseDTO toResponseDTO(Produto produto) {
        return new ProdutoResponseDTO(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getPreco(),
                produto.getQuantidadeEstoque(),
                produto.getVendedor().getId(),
                produto.getVendedor().getNome()
        );
    }

    /**
     * Lista todos os produtos cadastrados.
     */
    @Transactional(readOnly = true) // Indica que é apenas leitura, otimiza a transação
    public List<ProdutoResponseDTO> listarTodos() {
        // Busca todos os produtos no banco e converte para DTO
        return produtoRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    /**
     * Busca um produto pelo ID.
     */
    @Transactional(readOnly = true)
    public ProdutoResponseDTO buscarPorId(Long id) {
        // Se não encontrar, lança exceção personalizada
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com ID: " + id));
        return toResponseDTO(produto);
    }

    /**
     * Cria um novo produto.
     */
    @Transactional
    public ProdutoResponseDTO criar(ProdutoRequestDTO requestDTO) {
        // Busca o vendedor pelo ID fornecido
        Usuario vendedor = usuarioRepository.findById(requestDTO.getVendedorId())
                .orElseThrow(() -> new ResourceNotFoundException("Vendedor não encontrado com ID: " + requestDTO.getVendedorId()));

        // Cria uma nova instância de Produto
        Produto produto = new Produto();
        produto.setNome(requestDTO.getNome());
        produto.setDescricao(requestDTO.getDescricao());
        produto.setPreco(requestDTO.getPreco());
        produto.setQuantidadeEstoque(requestDTO.getQuantidadeEstoque());
        produto.setVendedor(vendedor);

        // Salva no banco de dados
        Produto saved = produtoRepository.save(produto);
        return toResponseDTO(saved);
    }

    /**
     * Atualiza um produto existente.
     */
    @Transactional
    public ProdutoResponseDTO atualizar(Long id, ProdutoRequestDTO requestDTO) {
        // Verifica se o produto existe
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com ID: " + id));

        // Se o vendedor foi alterado, busca o novo vendedor
        if (!produto.getVendedor().getId().equals(requestDTO.getVendedorId())) {
            Usuario novoVendedor = usuarioRepository.findById(requestDTO.getVendedorId())
                    .orElseThrow(() -> new ResourceNotFoundException("Vendedor não encontrado com ID: " + requestDTO.getVendedorId()));
            produto.setVendedor(novoVendedor);
        }

        // Atualiza os campos permitidos
        produto.setNome(requestDTO.getNome());
        produto.setDescricao(requestDTO.getDescricao());
        produto.setPreco(requestDTO.getPreco());
        produto.setQuantidadeEstoque(requestDTO.getQuantidadeEstoque());

        // O Spring gerencia a atualização automaticamente ao final do método transacional
        return toResponseDTO(produto);
    }

    /**
     * Exclui um produto pelo ID.
     */
    @Transactional
    public void excluir(Long id) {
        // Verifica se o produto existe
        if (!produtoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Produto não encontrado com ID: " + id);
        }
        produtoRepository.deleteById(id);
    }

    /**
     * Lista produtos de um vendedor específico.
     */
    @Transactional(readOnly = true)
    public List<ProdutoResponseDTO> listarPorVendedor(Long vendedorId) {
        // Verifica se o vendedor existe
        if (!usuarioRepository.existsById(vendedorId)) {
            throw new ResourceNotFoundException("Vendedor não encontrado com ID: " + vendedorId);
        }
        return produtoRepository.findByVendedorId(vendedorId)
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }
}