import {Question} from './question';

export class Test {
  name: string;
  description: string;
  additionalFields: string[];
  questions: Question[];

  constructor() {
    this.additionalFields = [];
  }
}
