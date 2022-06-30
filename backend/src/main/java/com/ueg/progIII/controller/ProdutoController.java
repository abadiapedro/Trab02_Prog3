package com.ueg.progIII.controller;

import com.ueg.progIII.model.Produto;
import com.ueg.progIII.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( path = "api/v1/produto" )
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping()
    public List<Produto> listarTodos(){
        return produtoService.listarTodos();
    }

    @GetMapping( path = "{id}")
    public Produto getProduto(@PathVariable("id") Long id) {
        return produtoService.getProduto(id);
    }

    @GetMapping( path ="nome/{nome}")
    public List<Produto> getProdutoByNome(@PathVariable("nome") String nome){
        return produtoService.getProdutoByNome(nome);
    }

    @PostMapping
    public Produto incluir(@RequestBody Produto produto) {
        return produtoService.incluir(produto);
    }

    @DeleteMapping( path = "{id}")
    public Produto remover(@PathVariable("id") Long id) {
        return produtoService.remover(id);
    }

    @PatchMapping( path = "{id}")
    public Produto alterar(@RequestBody Produto produto, @PathVariable("id") Long id) {
        return produtoService.alterar(produto, id);
    }
}
