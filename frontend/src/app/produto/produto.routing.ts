import { Routes } from "@angular/router";
import { ProdutoFormComponent } from "./produto-form/produto-form.component";
import { ProdutoListComponent } from "./produto-list/produto-list.component";
import { ProdutoComponent } from "./produto.component";

export const ProdutoRoutes: Routes = [
    {
        path: "produto",
        component: ProdutoComponent,
        children: [
            {
               path: "",
               component: ProdutoListComponent
            },
            {
                path: "novo",
                component: ProdutoFormComponent
            },
            {
                path: "editar/:id",
                component: ProdutoFormComponent
            }
        ]
    },


]
