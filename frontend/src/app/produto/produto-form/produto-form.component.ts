import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Produto } from '../shared/produto';
import { ProdutoService } from '../shared/produto.service';

@Component({
  selector: 'app-produto-form',
  templateUrl: './produto-form.component.html',
  styleUrls: ['./produto-form.component.css']
})
export class ProdutoFormComponent implements OnInit {

  produto: Produto = new Produto();
  constructor(
    private produtoService: ProdutoService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id'); //pegar na rota atual o parametro
    if (id) {
      this.produtoService.getById(parseInt(id))?.subscribe((produto) => {
          if (produto) {
            this.produto = produto;
          }
        }, erro => {
          alert("Erro ao buscar o produto com id: "+id);
        }
      )
    };
  }

  public salvar(produto: Produto) {
    let acao="criado";
    if(produto.id){
      acao = "alterado";
    }
    this.produtoService.salvar(produto)?.subscribe((produto) => {
      alert("Produto "+acao+" com sucesso!")
      console.log(produto);
      this.produto = produto;
      this.router.navigate(['produto']);

    }, erro => {
      alert(erro?.error?.message);
      console.log(erro);
    })
  }

}
