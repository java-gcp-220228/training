import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FilteringDemoComponent } from './filtering-demo.component';

describe('FilteringDemoComponent', () => {
  let component: FilteringDemoComponent;
  let fixture: ComponentFixture<FilteringDemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FilteringDemoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FilteringDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
