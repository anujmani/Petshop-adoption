// src/app/model/paginated-response.ts
import { Pet } from './pets';

export interface PaginatedResponse {
  content: Pet[];
  totalElements: number;
  totalPages: number;
}
