import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ProvidedService } from './provided-service/providedService';
import { environment } from '../environments/environment'
import { ProvidedServiceSearch } from './provided-service/provided-service-list/providedServiceSearch';

@Injectable({
  providedIn: 'root'
})
export class ProvidedServiceService {

  apiURL: string = environment.apiURLBase + '/api/provided-services';

  constructor(private http: HttpClient) { }

  saveProvidedService(providedService: ProvidedService): Observable<ProvidedService> {
    return this.http.post<ProvidedService>(this.apiURL, providedService);
  }

  searchProvidedService(name: string, month: number): Observable<ProvidedServiceSearch[]> {
    const httpParams = new HttpParams().set("name", name).set("month", month ? month.toString() : '');
    
    const url= this.apiURL + "?" + httpParams.toString();
    
    console.log(url);
    return this.http.get<any>(url);
  }
}
