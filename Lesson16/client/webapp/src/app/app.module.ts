import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

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



@NgModule({
  declarations: [
    AppComponent,
    AppNavbarComponent,
    LoginFormComponent,
    UserComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
    NgbModule.forRoot(),
    AppRoutingModule
  
  ],
  providers: [
    UserService,
    {
      provide: HTTP_INTERCEPTORS
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
