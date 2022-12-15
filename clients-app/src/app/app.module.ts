import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { TemplateModule } from './template/template.module';
import { HomeComponent } from './home/home.component';
import { ClientsModule } from './clients/clients.module';
import { ClientsService } from './clients.service';
import { ProvidedServiceModule } from './provided-service/provided-service.module';
import { ProvidedServiceService } from './provided-service.service';
import { LoginComponent } from './login/login.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    TemplateModule,
    ClientsModule,
    ProvidedServiceModule
    
  ],
  providers: [
    ClientsService,
    ProvidedServiceService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
