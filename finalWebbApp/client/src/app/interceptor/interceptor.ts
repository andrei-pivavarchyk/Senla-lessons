import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
@Injectable()
export class TokenInterceptor implements HttpInterceptor {
  constructor() {}
  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
  
    var token=localStorage.getItem('currentUser');
    if(token==null){
      token="token";
    }
   const request2 = request.clone({
    headers: request.headers.set('Authorization', token)
     
    });
    return next.handle(request2);
  }
}

