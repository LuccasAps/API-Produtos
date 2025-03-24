package com.github.LuccasAps.Produtos.API.repositories;

import com.github.LuccasAps.Produtos.API.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
    List<Produto> findByNome(String nome);
}
