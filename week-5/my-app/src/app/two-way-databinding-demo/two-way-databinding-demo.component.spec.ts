import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TwoWayDatabindingDemoComponent } from './two-way-databinding-demo.component';

describe('TwoWayDatabindingDemoComponent', () => {
  let component: TwoWayDatabindingDemoComponent;
  let fixture: ComponentFixture<TwoWayDatabindingDemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TwoWayDatabindingDemoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TwoWayDatabindingDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
