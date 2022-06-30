import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProdutoComponent } from './produto.component';
import { ProdutoFormComponent } from './produto-form/produto-form.component';
import { ProdutoListComponent } from './produto-list/produto-list.component';
import { RouterModule } from '@angular/router';
import { ProdutoRoutes } from './produto.routing';
import { FormsModule } from '@angular/forms';
import { MatDatepickerModule} from "@angular/material/datepicker";
import {MatInputModule} from "@angular/material/input";


@NgModule({
  declarations: [
    ProdutoComponent,
    ProdutoFormComponent,
    ProdutoListComponent
  ],
  imports: [
    FormsModule,
    CommonModule,
    RouterModule.forChild(ProdutoRoutes),
    MatDatepickerModule,
    MatInputModule
  ]
})
export class ProdutoModule { }
