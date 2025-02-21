import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GestionaParticipantesComponent } from './gestiona-participantes.component';

describe('GestionaParticipantesComponent', () => {
  let component: GestionaParticipantesComponent;
  let fixture: ComponentFixture<GestionaParticipantesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GestionaParticipantesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GestionaParticipantesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
