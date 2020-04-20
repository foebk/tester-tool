import {Answer} from './answer';

export class Question {
  text: string;
  answers: Answer[];
  points: number;
  severalAnswers: boolean;


  constructor() {
    this.text = null;
    this.points = 1;
  }
}
