package com.ueg.progIII.service;

import com.ueg.progIII.model.Produto;
import com.ueg.progIII.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto getProduto(Long id) {
        this.validarProdutoExiste(id);
        Optional<Produto> produto = obterProdutoSeExiste(id);
        return produto.get();
    }

    public List<Produto> listarTodos(){
        return produtoRepository.findAll();
    }

    public Produto incluir(Produto produto){
        Boolean existeFabricante = produtoRepository.existeFabricante(produto.getFabricante());

        this.validarPesoProduto(produto.getPeso());

        if(existeFabricante) {
            throw new IllegalStateException("Fabricante: " + produto.getFabricante() + " já foi atribuido a outro produto.");
        }

        return produtoRepository.save(produto);
    }

    public Produto remover(Long id){
        Optional<Produto> produtoOptional = obterProdutoSeExiste(id);
        
        this.validarProdutoExiste(id);

        Produto produto = produtoOptional.get();
        produtoRepository.delete(produto);

        return produto;
    }

    private Optional<Produto> obterProdutoSeExiste(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto alterar(Produto produto, Long id){
       Optional<Produto> produtoOptional = obterProdutoSeExiste(id);

        this.validarProdutoExiste(id);
        this.validarPesoProduto(produto.getPeso());

       Produto produtoBD = produtoOptional.get();

        if(produto.getDataValidade() != null){
            produtoBD.setDataValidade(produto.getDataValidade());
        }

        if(!produto.getFabricante().isEmpty()){
            produtoBD.setFabricante(produto.getFabricante());
        }

        if(produto.getPeso() != null){
            produtoBD.setPeso(produto.getPeso());
        }


        produtoBD = produtoRepository.save(produtoBD);

       return produtoBD;
    }

    private void validarProdutoExiste(Long id){
        Optional<Produto> produto = produtoRepository.findById(id);
        if(produto.isEmpty()) {
            throw new IllegalStateException("Não existe Produto com o ID: " + id);
        }
    }

    private void validarPesoProduto(Double peso){
        if (peso <=0){
            throw new IllegalStateException("Produto não pode ter peso: "+ peso + ". Deve ser maior ou igual a 1");
        }
    }

    public List<Produto> getProdutoByNome(String nome) {
        List<Produto> produtos = produtoRepository.findByNome(nome);
        if(CollectionUtils.isEmpty(produtos)) {
            throw new IllegalAccessError("Nenhum produto com o nome: " + nome + " encontrado");
        }
        return produtos;
    }
}
