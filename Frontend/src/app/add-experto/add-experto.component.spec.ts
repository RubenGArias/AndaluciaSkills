import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddExpertoComponent } from './add-experto.component';

describe('AddExpertoComponent', () => {
  let component: AddExpertoComponent;
  let fixture: ComponentFixture<AddExpertoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddExpertoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddExpertoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
