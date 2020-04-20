import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {TestMakerComponent} from "./test-maker/test-maker.component";


const routes: Routes = [
  { path: 'test-maker-component', component: TestMakerComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
