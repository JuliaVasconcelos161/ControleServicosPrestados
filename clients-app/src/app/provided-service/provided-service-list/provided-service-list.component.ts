import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-provided-service-list',
  templateUrl: './provided-service-list.component.html',
  styleUrls: ['./provided-service-list.component.css']
})
export class ProvidedServiceListComponent implements OnInit{
  name?: string;
  month?: number;
  months: number[];

  constructor() {
    this.months = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12];
  }

  ngOnInit(): void {
      
  }

  searchService() {
    console.log(this.name, this.month);
  }
}
