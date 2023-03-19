/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { InputTopComponent } from './input-top.component';

describe('InputTopComponent', () => {
  let component: InputTopComponent;
  let fixture: ComponentFixture<InputTopComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InputTopComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InputTopComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
