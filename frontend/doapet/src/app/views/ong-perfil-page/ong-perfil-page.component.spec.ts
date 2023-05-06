/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { OngPerfilPageComponent } from './ong-perfil-page.component';

describe('OngPerfilPageComponent', () => {
  let component: OngPerfilPageComponent;
  let fixture: ComponentFixture<OngPerfilPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OngPerfilPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OngPerfilPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
