import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
//components
import { LoginFormComponent } from './login-form/login-form.component';
import { UserDataComponent } from './user-data/user-data.component';
//
const routes: Routes = [
  { path: 'login', component: LoginFormComponent },
  { path: 'userdata', component: UserDataComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}