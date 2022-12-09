import { Component } from '@angular/core';
import { Client } from '../client'

@Component({
  selector: 'app-clients-form',
  templateUrl: './clients-form.component.html',
  styleUrls: ['./clients-form.component.css']
})
export class ClientsFormComponent {
  client?: Client;

  constructor() { }

  ngOnInit(): void {
    
  }
}
