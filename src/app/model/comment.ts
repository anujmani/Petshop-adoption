import { Pet } from "./pets";

export interface Comment {
    comment: string;
    commentedBy: string;
    petId: number;
    date: Date;
  }