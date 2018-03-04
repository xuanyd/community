import {Component, Input, DoCheck} from "@angular/core";

import { GridTable } from "./grid-table";

@Component({
  selector: 'grid',
  templateUrl: "./grid.component.html"
})
export class GridComponent implements DoCheck{

  @Input()
  public gridTable:GridTable;

  ngDoCheck():void {
  	
  }
}