import {Component, Input, DoCheck} from "@angular/core";

import { ModalConfirm } from "./modal-confirm";

@Component({
  selector: 'confirm',
  templateUrl: "./confirm.component.html"
})
export class ConfirmComponent implements DoCheck{

  @Input()
  public modalConfirm:ModalConfirm;

  public showStyle: String='block';

  ngDoCheck():void {
    if(this.modalConfirm.show) {
      this.showStyle = 'block';
    } else {
      this.showStyle = 'none';
    }
  }

  confirm() {
    this.modalConfirm.confirm = true;
    this.close();
    this.modalConfirm.select();
  }

  cancel() {
    this.modalConfirm.confirm = false;
    this.close();
    this.modalConfirm.select();
  }

  close() {
  	this.modalConfirm.show = false;
  }
}