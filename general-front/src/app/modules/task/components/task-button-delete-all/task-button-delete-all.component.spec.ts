import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TaskButtonDeleteAllComponent } from './task-button-delete-all.component';

describe('TaskButtonDeleteAllComponent', () => {
  let component: TaskButtonDeleteAllComponent;
  let fixture: ComponentFixture<TaskButtonDeleteAllComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TaskButtonDeleteAllComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TaskButtonDeleteAllComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
