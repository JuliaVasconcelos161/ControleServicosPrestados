import { Component } from '@angular/core';
import { Router }  from '@angular/router';
import { ClientsService } from 'src/app/clients.service';
import { Client } from '../client';

@Component({
  selector: 'app-clients-list',
  templateUrl: './clients-list.component.html',
  styleUrls: ['./clients-list.component.css']
})
export class ClientsListComponent {
  clients: Client[] = [];

  constructor(
    private service: ClientsService,
    private router: Router){}

  ngOnInit(): void {
    this.service.getClients()
    .subscribe( response => this.clients = response );
  }

  newRegistration() {
    this.router.navigate(['/clients-form'])
  }
}
