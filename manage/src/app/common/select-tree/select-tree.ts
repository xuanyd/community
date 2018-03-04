export class SelectTree {

  constructor(
  	public treeData: Object,
  	public treeName: String,
  	public formControlName: String
  ){}

  public static defaultSelectTree = new SelectTree('','selectTree','selectTree')
}