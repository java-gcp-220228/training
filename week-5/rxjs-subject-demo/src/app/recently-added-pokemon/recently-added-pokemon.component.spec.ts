import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecentlyAddedPokemonComponent } from './recently-added-pokemon.component';

describe('RecentlyAddedPokemonComponent', () => {
  let component: RecentlyAddedPokemonComponent;
  let fixture: ComponentFixture<RecentlyAddedPokemonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RecentlyAddedPokemonComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RecentlyAddedPokemonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
