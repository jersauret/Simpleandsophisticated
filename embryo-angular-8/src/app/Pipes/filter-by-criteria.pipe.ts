import { Pipe, PipeTransform } from '@angular/core';
import { Product } from '../Models/product';

@Pipe({
  name: 'filterByCriteria'
})
export class FilterByCriteriaPipe implements PipeTransform {

  transform(items: Product[], searchText: string): any[] {
    if(!items) return [];
    if(!searchText) return items;
    searchText = searchText.toLowerCase();
    return items.filter( it => {
      return it.name.toLowerCase().includes(searchText);
    });
   }
}
