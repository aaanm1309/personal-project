import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-task-input-add-itens',
  templateUrl: './task-input-add-itens.component.html',
  styleUrls: ['./task-input-add-itens.component.css']
})
export class TaskInputAddItensComponent {

  @Output() public emmitItemTaskList = new EventEmitter();

  public addItemTaskList: string = "";

  constructor(){}

  ngOnInit() {}

  submitItemTaskList(){
    this.addItemTaskList = this.addItemTaskList.trim();
    if (this.addItemTaskList !== ""){
      // console.log(this.addItemTaskList);
      this.emmitItemTaskList.emit(this.addItemTaskList);
      this.addItemTaskList = "";
    }
  }



}
