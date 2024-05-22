import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { FilterParam } from '../model/FilterParam';

@Injectable({
  providedIn: 'root',
})
export class SearchFormServiceService {
  
  filterParam: FilterParam = new FilterParam();

  constructor() {}
  
  getFilteredParams(searchForm: FormGroup): FilterParam {
    const name = searchForm.get('name')?.value || '';
    const color = searchForm.get('color')?.value || '';
    const age= searchForm.get('age')?.value || '';

    const filterParam = new FilterParam(name, color,age);
    return filterParam;
  }
}

