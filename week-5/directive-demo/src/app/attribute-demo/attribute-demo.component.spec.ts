import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AttributeDemoComponent } from './attribute-demo.component';

describe('AttributeDemoComponent', () => {
  let component: AttributeDemoComponent;
  let fixture: ComponentFixture<AttributeDemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AttributeDemoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AttributeDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
