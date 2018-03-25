import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import  { AppRoutingModule } from './app-routing.module';
import { LoginComponent } from './login/login.component';
import { RegistComponent } from './regist/regist.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistComponent
  ],
  imports: [
  	AppRoutingModule,
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
