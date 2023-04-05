import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './components/header/header.component';
import { TaskButtonDeleteAllComponent } from './components/task-button-delete-all/task-button-delete-all.component';
import { TaskInputAddItensComponent } from './components/task-input-add-itens/task-input-add-itens.component';
import { TaskListComponent } from './components/task-list/task-list.component';
import { TaskComponent } from './pages/task/task.component';



@NgModule({
  declarations: [
    HeaderComponent,
    TaskButtonDeleteAllComponent,
    TaskInputAddItensComponent,
    TaskListComponent,
    TaskComponent
  ],
  imports: [
    CommonModule
  ]
})
export class TaskModule { }
