import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddParticipanteComponent } from './add-participante.component';

describe('AddParticipanteComponent', () => {
  let component: AddParticipanteComponent;
  let fixture: ComponentFixture<AddParticipanteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddParticipanteComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddParticipanteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
