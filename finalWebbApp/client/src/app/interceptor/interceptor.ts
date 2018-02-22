import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpResponse
} from '@angular/common/http';
import { UserService } from '../service/user.service';
import { Observable } from 'rxjs/Observable';
@Injectable()
export class TokenInterceptor implements HttpInterceptor {
    
  constructor() {}
  
  intercept(request: HttpRequest<any>, next: HttpHandler): 
  Observable<HttpEvent<any>> {
  
   var token=localStorage.getItem('currentuser');
    if(token!=null){
      request = request.clone({
        setHeaders: {
          Authorization: `Bearer ${token}`
        }
      });
    }
    return next.handle(request);
  }
}