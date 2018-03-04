import {Component, Input, DoCheck} from "@angular/core";

import { ModalAlert } from "./modal-alert";

@Component({
  selector: 'modal',
  templateUrl: "./modal.component.html"
})
export class ModalComponent implements DoCheck{

  @Input()
  public modalAlert:ModalAlert;

  public showStyle: String='block';

  ngDoCheck():void {
    if(this.modalAlert.show) {
      this.showStyle = 'block'
    } else {
      this.showStyle = 'none'
    }
  }

  close() {
  	this.modalAlert.show = false
  }
}