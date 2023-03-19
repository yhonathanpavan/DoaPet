/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { InputInsideComponent } from './input-inside.component';

describe('InputInsideComponent', () => {
  let component: InputInsideComponent;
  let fixture: ComponentFixture<InputInsideComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InputInsideComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InputInsideComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
