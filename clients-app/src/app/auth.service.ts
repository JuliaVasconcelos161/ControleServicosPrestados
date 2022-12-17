import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserLogin } from './login/userLogin';

import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root'
})
export class AuthService {

  apiURL: string = environment.apiURLBase + "/api/users";
  constructor(
    private http: HttpClient
  ) { }

  saveUser(userLogin: UserLogin) : Observable<any> {
    return this.http.post<any>(this.apiURL, userLogin)
  }
}
