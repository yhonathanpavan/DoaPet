/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { PreLoginPageComponent } from './pre-login-page.component';

describe('PreLoginPageComponent', () => {
  let component: PreLoginPageComponent;
  let fixture: ComponentFixture<PreLoginPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PreLoginPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PreLoginPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
