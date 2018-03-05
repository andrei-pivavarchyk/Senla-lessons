import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfilebookComponent } from './profilebook.component';

describe('ProfilebookComponent', () => {
  let component: ProfilebookComponent;
  let fixture: ComponentFixture<ProfilebookComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfilebookComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfilebookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
