import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserLogin } from './login/userLogin';

import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root'
})
export class AuthService {

  apiURL: string = environment.apiURLBase + "/api/users";
  tokenURL: string = environment.apiURLBase + environment.getTokenUrl;
  clientId: string = environment.clientId;
  clientSecret: string = environment.clientSecret;
  constructor(
    private http: HttpClient
  ) { }

  saveUser(userLogin: UserLogin) : Observable<any> {
    return this.http.post<any>(this.apiURL, userLogin)
  }

  tryLogin(username: string, password: string): Observable<any> {
    const params = new HttpParams()
      .set('username', username)
      .set('password', password)
      .set('grant_type', 'password');

    const headers = {
      'Authorization': 'Basic ' + btoa(`${this.clientId}:${this.clientSecret}`),
      'Content-Type': 'application/x-www-form-urlencoded'
    };

    return this.http.post(this.tokenURL, params.toString() , { headers: headers });
  }
}
