import {Answer} from './answer';

export class Question {
  text: string;
  answers: Answer[];
  tempAnswers: Answer[];
  points: number;

  constructor() {
    this.text = null;
    this.points = 1;
  }
}
