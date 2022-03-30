import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MphToKphComponent } from './mph-to-kph.component';

describe('MphToKphComponent', () => {
  let component: MphToKphComponent;
  let fixture: ComponentFixture<MphToKphComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MphToKphComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MphToKphComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
