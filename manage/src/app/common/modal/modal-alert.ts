export class ModalAlert {
  constructor(
  	public title: String,
  	public content: String,
  	public show: boolean,
  	public success: boolean
  ){}

  public static defaultModalAlert = new ModalAlert('测试','提示',false,false)
}