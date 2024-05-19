import { Component } from '@angular/core';

@Component({
  selector: 'app-adoptionpage',
  templateUrl: './adoptionpage.component.html',
  styleUrls: ['./adoptionpage.component.css']
})
export class AdoptionpageComponent {
  selectedFilter: string | null = null;

  constructor() { }

  filterPets(type: string): void {
    this.selectedFilter = type;
  }

  isFilterSelected(type: string): boolean {
    return this.selectedFilter === type;
  }

}
