import { Component, OnInit} from '@angular/core'
import { Router } from '@angular/router'
import { Validators, FormControl, FormGroup, FormBuilder } from '@angular/forms'

@Component({
  selector: 'c-login',
  templateUrl: './login.component.html',
  styleUrls: [
    //'./login.component.scss'
  ]
})

export class LoginComponent implements OnInit {
  
  constructor(private router: Router) {
  }

	ngOnInit() {
	}

	login() {
	}
}