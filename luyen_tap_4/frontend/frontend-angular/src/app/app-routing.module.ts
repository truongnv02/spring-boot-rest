import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeListComponent } from './components/employee-list/employee-list.component';
import { CreateEmployeeComponent } from './components/create-employee/create-employee.component';
import { UpdateEmployeeComponent } from './components/update-employee/update-employee.component';
import { EmployeeDetailComponent } from './components/employee-detail/employee-detail.component';

const routes: Routes = [
  {path: 'employees', component: EmployeeListComponent},
  {path: '', redirectTo: 'employees', pathMatch: 'full'},
  {path: 'create-employee', component: CreateEmployeeComponent},
  {path: 'update-employee/:id', component: UpdateEmployeeComponent},
  {path: 'detail-employee/:id', component: EmployeeDetailComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
