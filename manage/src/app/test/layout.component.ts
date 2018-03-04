import { Component, OnInit, Output} from '@angular/core';
import { Router } from '@angular/router';
import { Pagination } from '../common/page/pagination';
import { SelectTree } from '../common/select-tree/select-tree';
import { ModalAlert } from '../common/modal/modal-alert';
import { ModalConfirm } from '../common/confirm/modal-confirm';
import { GridTable } from '../common/grid/grid-table';

@Component({
  selector: 'c-test-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.scss']
})

export class LayoutComponent implements OnInit {
	
	@Output()
  public pagination:Pagination = Pagination.defaultPagination;

  @Output()
  public selectTree:SelectTree = SelectTree.defaultSelectTree;

  @Output()
  public modalAlert:ModalAlert = ModalAlert.defaultModalAlert;

  @Output()
  public modalConfirm:ModalConfirm = ModalConfirm.defaultModalConfirm;

  @Output()
  public gridTable:GridTable = GridTable.defaultGridTable;

	constructor(private router: Router) {
    
	}

  ngOnInit() {
    this.selectTree.treeData = [{id:1,name:'测试'},{id:2,name:'测试'}];
    this.selectTree.treeName = 'testTreeName';
    this.initJobExceptionList();
    this.pagination.changePage = (() => {
      this.initJobExceptionList();
    });

    this.gridTable.headers = [{name:'name',displayName:'头部xxx'},
      {name:'address',displayName:'头部xxx'},{name:'phone',displayName:'头部xxx'}]
    this.gridTable.dataList = [
      {name:'张三',address:'北京',phone:'13333338889'},
      {name:'李四',address:'上海',phone:'13333338889'},
      {name:'李四',address:'上海',phone:'13333338889'}
      ] 
  }
  initJobExceptionList(){
    this.pagination.totalItems = 60;
  }

  tip() {
    this.modalAlert.success = true
    this.modalAlert.show = true
  }

  exception() {
    this.modalAlert.success = false
    this.modalAlert.show = true
  }

  confirm(){
    this.modalConfirm.show = true
    this.modalConfirm.select = (() => {
      console.log(this.modalConfirm.confirm)
    })
  }
}
