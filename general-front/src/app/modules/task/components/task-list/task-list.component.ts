import { Component, DoCheck, OnInit } from '@angular/core';
import { Task, TaskCreate } from '../../model/task';
import { TaskService } from 'src/app/services/task.service';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit, DoCheck {

  public taskList: Array<Task> = [
    // {taskName: "Minha nova Task", checked: true},
    // {taskName: "Minha nova Task 2", checked: false},
  ];

  public taskAdd: TaskCreate = 
    {taskName: "", user: {id:0 }};
  public userId: string = localStorage.getItem('userId');

  constructor(
    private service: TaskService){}


  ngDoCheck(): void {
    this.taskList.sort((first, last) => Number(first.checked) - Number(last.checked));
    // console.log("algo foi alterado")
  }

  ngOnInit(): void {
    this.findByIdAndUser();
  }


  findByIdAndUser() {
    this.service.findAllByUserMin(this.userId).subscribe(resp => {
      this.taskList = resp;
    }, error => console.error(error));
  }

  addTaskList(event: string) {
    console.log("task-list : "+event);
    // this.service.deleteItemFromTaskList(this.taskList[event].key);
    this.taskAdd.taskName = event;
    this.taskAdd.user.id = Number(this.userId);
    console.log("task-list : "+this.taskAdd);

    this.service.addTaskList(this.taskAdd).subscribe(resp => {
      this.findByIdAndUser();
    }, error => console.error(error));

  }

  deleteItemFromTaskList(event: number) {
    console.log(this.taskList[event].key);
    this.service.deleteItemFromTaskList(this.taskList[event].key).subscribe(resp => {
      this.findByIdAndUser();
    }, error => console.error(error));


  }

  deleteAllItensFromTaskList() {
    const confirm = window.confirm('Are you sure you want to delete all the itens?');

    if (confirm === true) {
      this.service.deleteAllItensFromTaskList(this.userId).subscribe(
        resp => {
        this.findByIdAndUser();
      }, error => console.error(error)
      );
    }
  }

  public validationInputChanged(event: string, index: number): void {
    if (!event.length) {
      const confirm = window.confirm("Task vazia, deseja Deletar a task?")
      if (confirm){
        this.deleteItemFromTaskList(index);
      }
    } else{
      console.log("alterou qualquer outra coisa n: " + index);
      console.log("implementar alteração  n: " + index);
      
    }
  }



}
