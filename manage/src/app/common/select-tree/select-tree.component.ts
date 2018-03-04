import {Component, Input} from "@angular/core"

import { SelectTree } from "./select-tree"

@Component({
  selector: 'select-tree',
  templateUrl: "./select-tree.component.html"
})
export class SelectTreeComponent {

  @Input()
  public selectTree:SelectTree

  public treeData: Object 

  public treeName: String
  
}