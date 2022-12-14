import { Component, OnInit } from '@angular/core';
import { Client } from '../../clients/client';
import { ClientsService } from '../../clients.service'
import { ProvidedService } from '../providedService';
import { ProvidedServiceService } from '../../provided-service.service';


@Component({
  selector: 'app-provided-service-form',
  templateUrl: './provided-service-form.component.html',
  styleUrls: ['./provided-service-form.component.css']
})
export class ProvidedServiceFormComponent implements OnInit {
    clients: Client[] = [];
    providedService: ProvidedService;
    success: boolean = false;
    errors?: String[];
    
    constructor(
      private clientService: ClientsService,
      private service: ProvidedServiceService
    ) {
      this.providedService = new ProvidedService();
    }

    ngOnInit(): void {
        this.clientService
          .getClients()
          .subscribe( response => this.clients = response);
    }

    onSubmit() {
      this.service
        .saveProvidedService(this.providedService)
        .subscribe(response => {
          this.success = true;
          this.errors = [];
          this.providedService = new ProvidedService();
        }, errorResponse => {
          this.success = false;
          this.errors = errorResponse.error.errors;
        });
    }
}
