import { Component, OnInit } from '@angular/core';
import { Client } from '../../clients/client';
import { ClientsService } from '../../clients.service'
import { ProvidedService } from '../providedService';
@Component({
  selector: 'app-provided-service-form',
  templateUrl: './provided-service-form.component.html',
  styleUrls: ['./provided-service-form.component.css']
})
export class ProvidedServiceFormComponent implements OnInit {
    clients: Client[] = [];
    service: ProvidedService;
    
    constructor(
      private clientService: ClientsService,
    ) {
      this.service = new ProvidedService();
    }

    ngOnInit(): void {
        this.clientService
          .getClients()
          .subscribe( response => this.clients = response);
    }

    onSubmit() {
      console.log(this.service);
    }
}
