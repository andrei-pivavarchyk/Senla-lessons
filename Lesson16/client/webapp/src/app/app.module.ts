import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppNavbarComponent } from './app-navbar/app-navbar.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { UserDataComponent } from './user-data/user-data.component';
import { UserComponent } from './user/user.component';
//for two binding in forms
import { FormsModule } from '@angular/forms';
//for http
import { HttpClientModule } from '@angular/common/http';
import { UserService } from './service/user.service';
//routing 
import { AppRoutingModule }     from './app-routing.module';
//



@NgModule({
  declarations: [
    AppComponent,
    AppNavbarComponent,
    LoginFormComponent,
    UserDataComponent,
    UserComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    NgbModule.forRoot(),
    AppRoutingModule
  
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
