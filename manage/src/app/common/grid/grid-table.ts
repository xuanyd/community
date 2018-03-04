export class GridTable {
	constructor(
		public headers: any,
		public dataList: any
		){}
  public static defaultGridTable = new GridTable([{name:'xxx'},{name:'xxx'},{name:'xxx'}],[])
}