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
//interceptor
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import{TokenInterceptor} from './interceptor/interceptor';
import { CategoryComponent } from './category/category.component';
import { CatalogComponent } from './catalog/catalog.component';
import { FooterComponent } from './footer/footer.component';
import { MainComponent } from './main/main.component';
import { RegistrationComponent } from './registration/registration.component';
import { ProfileComponent } from './profile/profile.component';
import { BookService } from './service/book.service';



@NgModule({
  declarations: [
    AppComponent,
    AppNavbarComponent,
    LoginFormComponent,
    UserDataComponent,
    UserComponent,
    CategoryComponent,
    CatalogComponent,
    FooterComponent,
    MainComponent,
    RegistrationComponent,
    ProfileComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    NgbModule.forRoot(),
    AppRoutingModule
  
  ],
  providers: [
    UserService,
    BookService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true,
      
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
