import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddPruebaComponent } from './add-prueba.component';

describe('AddPruebaComponent', () => {
  let component: AddPruebaComponent;
  let fixture: ComponentFixture<AddPruebaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddPruebaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddPruebaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
