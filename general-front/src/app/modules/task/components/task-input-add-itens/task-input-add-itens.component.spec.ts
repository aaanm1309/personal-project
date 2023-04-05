import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TaskInputAddItensComponent } from './task-input-add-itens.component';

describe('TaskInputAddItensComponent', () => {
  let component: TaskInputAddItensComponent;
  let fixture: ComponentFixture<TaskInputAddItensComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TaskInputAddItensComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TaskInputAddItensComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
