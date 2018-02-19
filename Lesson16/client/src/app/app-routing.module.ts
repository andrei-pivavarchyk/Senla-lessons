import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

//components
import { LoginFormComponent } from './login-form/login-form.component';
import { UserDataComponent } from './user-data/user-data.component';
import { CatalogComponent } from './catalog/catalog.component';
import { MainComponent } from './main/main.component';
//
const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'login', component: LoginFormComponent },
  { path: 'userdata', component: UserDataComponent },
  { path: 'home', component: MainComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}