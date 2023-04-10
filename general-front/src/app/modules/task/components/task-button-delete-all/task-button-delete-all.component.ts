import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-task-button-delete-all',
  templateUrl: './task-button-delete-all.component.html',
  styleUrls: ['./task-button-delete-all.component.css']
})
export class TaskButtonDeleteAllComponent {
  @Output() public emmitDeleteAllTaskList = new EventEmitter();

  constructor(){}

  ngOnInit() {}

  submitDeleteAllTaskList(){
      this.emmitDeleteAllTaskList.emit();
  }


}
