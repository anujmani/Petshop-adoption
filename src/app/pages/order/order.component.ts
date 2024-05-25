import { Component, OnInit } from '@angular/core';
import { OrderService } from 'src/app/services/order.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
  orders: any[] = []; // Define an array to store orders

  constructor(private orderService: OrderService) { }

  ngOnInit(): void {
    this.loadOrders();
  }

  loadOrders() {
    // Call your order service to fetch orders
    this.orderService.getOrders().subscribe(
      (data) => {
        this.orders = data; // Assign fetched orders to the array
      },
      (error) => {
        console.error('Error fetching orders', error);
      }
    );
  }
}


