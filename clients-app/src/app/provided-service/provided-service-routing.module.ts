import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProvidedServiceFormComponent } from './provided-service-form/provided-service-form.component';
import { ProvidedServiceListComponent } from './provided-service-list/provided-service-list.component';

const routes: Routes = [
  { path: 'provided-service-form', component: ProvidedServiceFormComponent},
  { path: 'provided-service-list', component: ProvidedServiceListComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProvidedServiceRoutingModule { }
