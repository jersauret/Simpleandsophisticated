import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductDisplayByCriteriaComponent } from './product-display-by-criteria.component';

describe('ProductDisplayByCriteriaComponent', () => {
  let component: ProductDisplayByCriteriaComponent;
  let fixture: ComponentFixture<ProductDisplayByCriteriaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProductDisplayByCriteriaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductDisplayByCriteriaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
