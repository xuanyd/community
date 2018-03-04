export class ModalConfirm {
  constructor(
    public title: String,
    public content: String,
    public show: boolean,
    public confirm: boolean,
    public select:() => void
  ){}

  public static defaultModalConfirm = new ModalConfirm('测试','提示',false,false,function () {})
}