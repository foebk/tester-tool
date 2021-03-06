import {Answer} from './answer';

export class Question {
  id: string
  text: string;
  answers: Answer[];
  tempAnswers: Answer[];
  points: number;
  isValid: boolean;

  constructor() {
    this.text = null;
    this.points = -1;
    this.isValid = false;
  }
}
