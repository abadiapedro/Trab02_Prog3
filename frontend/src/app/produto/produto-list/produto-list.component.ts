import { Component, OnInit } from '@angular/core';
import { Produto } from '../shared/produto';
import { ProdutoService } from '../shared/produto.service';

@Component({
  selector: 'app-produto-list',
  templateUrl: './produto-list.component.html',
  styleUrls: ['./produto-list.component.css']
})
export class ProdutoListComponent implements OnInit {
  produtos: Produto[] = [];

  constructor(private produtoService: ProdutoService) { }

  ngOnInit(): void {
    console.log("antes")

    this.produtoService.getProdutos().subscribe((produtos: Produto[]) => {
      console.log("Produto", produtos);
      this.produtos = produtos;
    });

    console.log("depois");
  }

  confirmaRemocao(produto: Produto) {
    let mensagem = "Deseja remover o produto: " + produto.nome + " " + produto.dataValidade + ", Identificacao: " + produto.id + "?";
    if (confirm(mensagem)) {
      this.produtoService.remover(produto.id)?.subscribe((produto) => {
        let produtoIdx = this.produtos.findIndex((value) => value.id == produto.id);
        this.produtos.splice(produtoIdx, 1);
        alert("Produto removido com sucesso!");

      }, erro => {
        alert("Erro ao excluir produto. Mensagem: " +erro?.error?.message);
      });
    }
  }

}
