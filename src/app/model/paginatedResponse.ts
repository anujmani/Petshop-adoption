// src/app/model/paginated-response.ts
import { Pet } from './pets';

export interface PaginatedResponse {
  content: [];
  totalElements: number;
  totalPages: number;
}
