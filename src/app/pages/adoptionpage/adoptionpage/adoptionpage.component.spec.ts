import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdoptionpageComponent } from './adoptionpage.component';

describe('AdoptionpageComponent', () => {
  let component: AdoptionpageComponent;
  let fixture: ComponentFixture<AdoptionpageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdoptionpageComponent]
    });
    fixture = TestBed.createComponent(AdoptionpageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
