import { NgModule }   from '@angular/core';
import { CommonModule }       from '@angular/common';
import { FormsModule, ReactiveFormsModule} from "@angular/forms";
import { UserComponent } from './user.component';
import { UserRoutingModule } from './user.routing.module';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    UserRoutingModule
  ],
  declarations: [
    UserComponent,
    LoginComponent,
    HomeComponent
  ],
  exports: [
  ],
  providers: []
})

export class UserModule {
}
