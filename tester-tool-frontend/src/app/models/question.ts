import {Answer} from "./answer";

export class Question {
  text: String;
  answers: Answer[];
  severalAnswers: boolean;


  constructor() {
    this.text = null
  }
}
