import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EvaluarParticipanteComponent } from './evaluar-participante.component';

describe('EvaluarParticipanteComponent', () => {
  let component: EvaluarParticipanteComponent;
  let fixture: ComponentFixture<EvaluarParticipanteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EvaluarParticipanteComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EvaluarParticipanteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
