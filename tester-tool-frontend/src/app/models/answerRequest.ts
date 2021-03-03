export class AnswerRequest {
  id: string;
  isCorrect: boolean;

  constructor(id: string, isCorrect: boolean) {
    this.id = id;
    this.isCorrect = isCorrect;
  }
}
