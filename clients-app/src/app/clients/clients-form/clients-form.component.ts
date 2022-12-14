import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Client } from '../client';
import { ClientsService } from '../../clients.service';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-clients-form',
  templateUrl: './clients-form.component.html',
  styleUrls: ['./clients-form.component.css']
})
export class ClientsFormComponent implements OnInit {
  client: Client;
  success: boolean = false;
  errors?: String[];
  id!: number;

  constructor( 
    private service: ClientsService,
    private router: Router,
    private activatedRoute: ActivatedRoute
    ) { 
    this.client = new Client();
  }

  ngOnInit(): void {
    let params: Observable<Params> = this.activatedRoute.params;
    params.subscribe( urlParams => {
      this.id = urlParams['id'];
      if(this.id) {
        this.service
        .getClientById(this.id)
        .subscribe(
          response => this.client = response ,
          errorResponse => this.client = new Client());
      }
    })
  }

  backToList() {
    this.router.navigate(['/clients-list']);
  }

  onSubmit() {
    if(this.id) {
      this.service
      .updateClient(this.client)
      .subscribe(response => {
        this.success = true;
        this.errors = [];
      }, errorResponse => {
        this.errors = ['Erro ao atualizar o cliente']
      });
    }
    else {
      this.service.saveClient(this.client).subscribe(response => {
        this.success = true;
        this.errors = [];
        this.client = response;
      }, errorResponse => {
        this.success = false;
        this.errors = errorResponse.error.errors;
      });
    }
    
  } 

}
