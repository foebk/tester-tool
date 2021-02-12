import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {TestMakerComponent} from './test-maker/test-maker.component';
import {OpenTestComponent} from './open-test/open-test.component';


const routes: Routes = [
  { path: 'create-test', component: TestMakerComponent},
  { path: 'open-test', component: OpenTestComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
