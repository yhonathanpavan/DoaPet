/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { IncludeRequestPageComponent } from './include-request-page.component';

describe('IncludeRequestPageComponent', () => {
  let component: IncludeRequestPageComponent;
  let fixture: ComponentFixture<IncludeRequestPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IncludeRequestPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IncludeRequestPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
