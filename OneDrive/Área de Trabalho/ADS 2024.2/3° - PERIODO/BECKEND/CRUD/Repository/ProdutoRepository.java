package com.example.marketplace.repository;

import com.example.marketplace.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Repositório JPA para a entidade Produto.
 */
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    // Método personalizado para buscar produtos por ID do vendedor
    List<Produto> findByVendedorId(Long vendedorId);
}