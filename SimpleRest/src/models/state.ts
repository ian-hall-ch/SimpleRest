import { Card } from './card';

export class State {
  id?: string;
  description: string;
  cards: Card[];
  lastModified: string;
}
