/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { IncludeAssistancePageComponent } from './include-assistance-page.component';

describe('IncludeAssistancePageComponent', () => {
  let component: IncludeAssistancePageComponent;
  let fixture: ComponentFixture<IncludeAssistancePageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IncludeAssistancePageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IncludeAssistancePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
