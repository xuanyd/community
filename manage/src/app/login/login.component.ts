import { Component, OnInit} from '@angular/core'
import { Router } from '@angular/router'
import { Validators, FormControl, FormGroup, FormBuilder } from '@angular/forms'
import { HttpService } from '../common/util/http.service'
import { LocalStorage } from '../common/storage/local.storage'


@Component({
  selector: 'c-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})

export class LoginComponent implements OnInit {
  loginBtnDisable:string='';
  loginForm: FormGroup;
  loginValid: boolean = true;
  connectionValid: boolean = true;
  connectErrMsg: string='';
  isLogin: boolean = false;
  constructor(private router: Router, 
    private ls: LocalStorage,
    private httpService: HttpService, private formBuilder: FormBuilder) {
    let userNameFc = new FormControl('admin', 
      Validators.compose([Validators.required, Validators.minLength(5), Validators.maxLength(15)]));
    let passwordFc = new FormControl('123456',
      Validators.compose([Validators.required, Validators.minLength(3), Validators.maxLength(15)]));
    this.loginForm = this.formBuilder.group({
      userName: userNameFc,
      password: passwordFc
    });
  }

	ngOnInit() {
	}

	login() {
    if (!this.loginForm.valid)
      return
    let that = this;
    that.isLogin = true;
    that.loginBtnDisable = 'disabled';
    that.httpService.request({
      method: "POST",
      url: "/admin/login",
      data: {
        username: that.loginForm.value.userName,
        password: that.loginForm.value.password
      }
    }).then(result => {
      if(result.success) {
        if(result.data.flag == "1000"){
          that.ls.setObject('userName', that.loginForm.value.userName);
          that.ls.setObject('token', result.data.token);
          that.router.navigate(["/app/home"]);
        }
      } else {
        that.connectErrMsg = result.msg;
        that.connectionValid = false;
        that.isLogin = false;
      }
    });
	}
}