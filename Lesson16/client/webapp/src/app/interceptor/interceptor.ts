import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { UserService } from '../service/user.service';
import { Observable } from 'rxjs/Observable';
@Injectable()
export class TokenInterceptor implements HttpInterceptor {
    
  constructor(public userService: UserService) {}
  
  intercept(request: HttpRequest<any>, next: HttpHandler): 
  Observable<HttpEvent<any>> {
    console.log('inter');
    request = request.clone({
      setHeaders: {
        Authorization: `Bearer ${localStorage.getItem('currentuser')}`
      }
    });
    return next.handle(request);
  }
}