import { Component } from '@angular/core';
import { Task } from '../../model/task';
import { TaskService } from 'src/app/services/task.service';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent {

  public taskList: Array<Task> = [
    // {taskName: "Minha nova Task", checked: true},
    // {taskName: "Minha nova Task 2", checked: false},
  ];

  constructor(
    private service: TaskService){}

  ngOnInit(): void {
    this.findByIdAndUser();
    console.log(this.taskList);
  }

  findByIdAndUser() {
    this.service.findAllByUserMin(4).subscribe(resp => {
      console.log(resp);
      this.taskList = resp;
      // resp.forEach(x => this.taskList.push(x.taskName,x.checked));
    });
    console.log(this.taskList);
  }

}
