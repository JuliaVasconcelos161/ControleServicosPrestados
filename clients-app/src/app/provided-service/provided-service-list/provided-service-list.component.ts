import { Component, OnInit } from '@angular/core';
import { ProvidedServiceService } from '../../provided-service.service';
import { ProvidedServiceSearch } from './providedServiceSearch';


@Component({
  selector: 'app-provided-service-list',
  templateUrl: './provided-service-list.component.html',
  styleUrls: ['./provided-service-list.component.css']
})
export class ProvidedServiceListComponent implements OnInit{
  name!: string;
  month!: number;
  months: number[];
  list!: ProvidedServiceSearch[];

  constructor(
    private service: ProvidedServiceService
  ) {
    this.months = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12];
  }

  ngOnInit(): void {
      
  }

  searchService() {
    this.service.searchProvidedService(this.name, this.month)
      .subscribe(response => this.list = response);
  }
}
