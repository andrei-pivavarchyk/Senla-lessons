import { Injectable } from '@angular/core';
import { User } from '../entity/user';
import { HttpClient, HttpHeaders, HttpHeaderResponse, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import 'rxjs/add/operator/map';
import { Http, Headers, Response } from '@angular/http';
import { Book } from '../entity/book';
import { catchError, map, tap } from 'rxjs/operators';


@Injectable()
export class BookService {

  private mainUrl='http://localhost:8080/controller-1.0-SNAPSHOT';
  private allBooksUrl = this.mainUrl+'/books';
  
  constructor(private http: HttpClient ) {
    
   }


   getAllBooks():Observable<HttpResponse<any>> {
    return this.http.get(this.allBooksUrl,
      {observe:'response'}
    )
    .map((response: HttpResponse<any>) => {
   
        var status=response.status;
        if (status) {
            return response;
        } else {
            return null;
        }
    });
  }




}
