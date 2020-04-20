import { Component, OnInit } from '@angular/core';
import {Question} from '../models/question';
import {Answer} from '../models/answer';

@Component({
  selector: 'app-test-maker',
  templateUrl: './test-maker.component.html',
  styleUrls: ['./test-maker.component.css']
})
export class TestMakerComponent implements OnInit {

  questions: Question[];

  constructor() { }

  ngOnInit(): void {
    this.questions = [];
  }

  newQuestion(): void {
    const question = new Question();
    question.answers = [new Answer(), new Answer()];
    this.questions.push(question);
    console.log(this.questions);
  }

  removeQuestion(question: Question): void {
    this.questions.splice(this.questions.indexOf(question), 1);
    console.log(this.questions.length);
  }

  addAnswer(question: Question): void {
    question.answers.push(new Answer());
  }

  setQuestionPoints(value: string, question: Question) {
    this.questions[this.questions.indexOf(question)].points = Number(value);
  }
}
