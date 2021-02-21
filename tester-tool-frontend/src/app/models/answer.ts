export class Answer {
  id: string
  text: string;
  isCorrect: boolean;

  constructor() {
    this.isCorrect = false;
    this.text = '';
  }
}
