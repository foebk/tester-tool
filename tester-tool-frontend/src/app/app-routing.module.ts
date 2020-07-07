import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {TestMakerComponent} from './test-maker/test-maker.component';


const routes: Routes = [
  { path: 'create-test', component: TestMakerComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
