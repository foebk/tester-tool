import {AnswerRequest} from "./answerRequest";

export class QuestionRequest {
  id: String;
  answers: AnswerRequest[];

  constructor(id: String, answers: AnswerRequest[]) {
    this.id = id;
    this.answers = answers;
  }
}
