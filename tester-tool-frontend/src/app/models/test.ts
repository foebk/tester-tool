import {Question} from './question';

export class Test {
  id: string
  name: string;
  description: string;
  additionalFields: string[];
  questions: Question[];

  constructor() {
    this.additionalFields = [];
  }
}
