import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MiEspecialidadComponent } from './mi-especialidad.component';

describe('MiEspecialidadComponent', () => {
  let component: MiEspecialidadComponent;
  let fixture: ComponentFixture<MiEspecialidadComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MiEspecialidadComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MiEspecialidadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
