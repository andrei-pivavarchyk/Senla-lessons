import { Injectable } from '@angular/core';
import{User} from '../entity/user'
@Injectable()
export class UserService {

  constructor() { }

  getString():String{
    return 'string';
  };
}
