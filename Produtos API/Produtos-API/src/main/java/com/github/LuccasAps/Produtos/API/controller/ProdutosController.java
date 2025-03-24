package com.github.LuccasAps.Produtos.API.controller;

import com.github.LuccasAps.Produtos.API.model.Produto;
import com.github.LuccasAps.Produtos.API.repositories.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutosController {

    private ProdutoRepository produtoRepository;

    public ProdutosController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Produto save(@RequestBody Produto produto) {
        System.out.println("Produto recebido " + produto);

        produto.setId(UUID.randomUUID().toString());

        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping("/{id}")
    public Produto getById(@PathVariable("id") String id) {
        return produtoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        produtoRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") String id, @RequestBody Produto produto) {
        produto.setId(id);
        produtoRepository.save(produto);
    }

    @GetMapping
    public List<Produto> buscar(@RequestParam("nome") String nome){
        return produtoRepository.findByNome(nome);
    }

}
