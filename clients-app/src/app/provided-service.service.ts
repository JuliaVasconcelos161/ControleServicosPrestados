import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ProvidedService } from './provided-service/providedService';
import { environment } from '../environments/environment'

@Injectable({
  providedIn: 'root'
})
export class ProvidedServiceService {

  apiURL: string = environment.apiURLBase + '/api/provided-services';

  constructor(private http: HttpClient) { }

  saveProvidedService(providedService: ProvidedService): Observable<ProvidedService> {
    return this.http.post<ProvidedService>(this.apiURL, providedService);
  }
}
