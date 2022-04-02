import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeePageComponent } from './employee-page/employee-page.component';
import { HomePageComponent } from './home-page/home-page.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { ManagerPageComponent } from './manager-page/manager-page.component';

const appRoutes: Routes = [
  { path: '', component: HomePageComponent },
  { path: 'login', component: LoginPageComponent },
  { path: 'employee', component: EmployeePageComponent },
  { path: 'manager', component: ManagerPageComponent }
];

@NgModule({
  imports: [
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } // <-- debugging purposes only
    )
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {}
