import { Component, OnInit,AfterContentInit,OnDestroy,ViewChild } from '@angular/core'
import { Validators, FormControl, FormGroup, FormBuilder,FormsModule,ReactiveFormsModule } from '@angular/forms'
import { HttpService } from '../../common/util/http.service'
import { Router } from '@angular/router'

@Component({
  selector: 'c-sitecfg-link',
  templateUrl: './link-add.component.html',
  styleUrls: ['./link.component.scss']
})

export class LinkAddComponent implements OnInit {
  
  linkAddForm: FormGroup
  addDisabled:string = ''
  constructor(private router: Router, private httpService: HttpService,
      private formBuilder: FormBuilder) {
      let nameFc = new FormControl('', Validators.compose([Validators.required,Validators.minLength(5), Validators.maxLength(15)]))
      let urlFc = new FormControl('', Validators.compose([Validators.required,Validators.minLength(5), Validators.maxLength(15)]))
      this.linkAddForm = this.formBuilder.group({
        name: nameFc,
        url: urlFc
      });
    }

	/**
  * 初始化
  */
  ngOnInit() {
  }

  ngOnDestroy(): void {
  }

  add() {
    if (!this.linkAddForm.valid)
      return
    let that = this;
    that.addDisabled = 'disabled'
    /*that.httpService.get("http://localhost:8081/admin/link-add", {
      name: this.linkAddForm.value.name,
      url: this.linkAddForm.value.url
    }, function (successful, data, res) {
      that.addDisabled = ''
      if (successful) {
        if (data.flag!='1000') {
          return
        }
        that.router.navigate(['/app/sitecfg/link'])
      }
    }, function (successful, msg, err) {
      that.addDisabled = ''
    })*/
  }

  back() {
    this.router.navigate(['/app/sitecfg/link'])
  }

}
