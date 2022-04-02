import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerPageComponent } from './manager-page.component';

describe('ManagerPageComponent', () => {
  let component: ManagerPageComponent;
  let fixture: ComponentFixture<ManagerPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManagerPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
