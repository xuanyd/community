import { Component, OnInit,AfterContentInit,OnDestroy,ViewChild } from '@angular/core'
import { Validators, FormControl, FormGroup, FormBuilder,FormsModule,ReactiveFormsModule } from '@angular/forms'
import { HttpService } from '../../common/util/http.service'
import { Router } from '@angular/router'

@Component({
  selector: 'c-sitecfg-column',
  templateUrl: './column-edit.component.html',
  styleUrls: ['./column.component.scss']
})

export class ColumnEditComponent implements OnInit {
  
  columnEditForm: FormGroup

  constructor(private router: Router, private httpService: HttpService,
      private formBuilder: FormBuilder) {
      let columnTypeFc = new FormControl('admin', Validators.compose([Validators.required]))
      let titleFc = new FormControl('admin', Validators.compose([Validators.required]))
      let contentFc = new FormControl('admin', Validators.compose([Validators.required]))
      this.columnEditForm = this.formBuilder.group({
        columnType: columnTypeFc,
        title: titleFc,
        content: contentFc
      });
    }

	/**
  * 初始化
  */
  ngOnInit() {
    let that = this
  }

  ngOnDestroy(): void {
  }

  add() {
    console.log(this.columnEditForm.value.columnType)
    console.log(this.columnEditForm.value.title)
  }

  back() {
   this.router.navigate(['/app/sitecfg/column'])
  }

}
