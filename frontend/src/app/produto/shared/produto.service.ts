import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { Produto } from './produto';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  urlBackend: string = "http://localhost:8080"

  constructor(private http: HttpClient) { }

  public getProdutos(): Observable<Produto[]> {
    return this.http.get<Produto[]>(this.urlBackend + '/api/v1/produto/')
  }
  public salvar(produto: Produto): Observable<Produto>|undefined{
    if(!produto.id){
      return this.http.post<Produto>(this.urlBackend+'/api/v1/produto/',produto)
    }else{
      return this.http.patch<Produto>(this.urlBackend+'/api/v1/produto/'+produto.id, produto)
    }

  }
  public getById(id: number): Observable<Produto>|undefined{
    return this.http.get<Produto>(this.urlBackend+'/api/v1/produto/'+id)
  }

  public remover(id: number): Observable<Produto>|undefined{
    return this.http.delete<Produto>(this.urlBackend+'/api/v1/produto/'+id)
  }
}
