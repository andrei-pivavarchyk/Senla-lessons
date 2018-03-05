import { Injectable } from '@angular/core';
import { User } from '../entity/user';
import { HttpClient, HttpHeaders, HttpHeaderResponse, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import 'rxjs/add/operator/map';
import { Http, Headers, Response } from '@angular/http';
import { Book } from '../entity/book';
import { catchError, map, tap } from 'rxjs/operators';
import { RequestOptions } from '@angular/http';
import { HttpParams} from '@angular/common/http';

@Injectable()
export class BookService {

  private mainUrl='http://localhost:8080/controller-1.0-SNAPSHOT';
  private allBooksUrl = this.mainUrl+'/books';
  
  constructor(private http: HttpClient ) {
    
   }


   getAllBooks(first:number,max:number):Observable<HttpResponse<any>> {
    let params: URLSearchParams = new URLSearchParams();
    params.set('appid', first.toString());
    params.set('cnt', max.toString());
    
    return this.http.get(this.allBooksUrl,{
        params: {
          first: first.toString(),
          max: max.toString()
        },
        observe: 'response'
      }
    )
    .map((response: HttpResponse<any>) => {
   
        var status=response.status;
        if (status) {
          console.log(response.body);
            return response;
        } else {
            return null;
        }
    });
  }




}
