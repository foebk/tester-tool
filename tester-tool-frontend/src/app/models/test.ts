import {Question} from './question';
import {AdditionalField} from "./additionalField";

export class Test {
  id: string
  name: string;
  description: string;
  additionalFields: AdditionalField[];
  questions: Question[];

  constructor() {
    this.additionalFields = [];
  }
}
