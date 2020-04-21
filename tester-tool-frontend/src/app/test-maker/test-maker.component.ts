import {Component, OnInit} from '@angular/core';
import {Question} from '../models/question';
import {Answer} from '../models/answer';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-test-maker',
  templateUrl: './test-maker.component.html',
  styleUrls: ['./test-maker.component.css']
})
export class TestMakerComponent implements OnInit {

  questions: Question[];
  firstFormGroups: FormGroup[];
  secondFormGroups: FormGroup[];

  // tslint:disable-next-line:variable-name
  constructor(private _formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.questions = [];
    this.firstFormGroups = [];
    this.secondFormGroups = [];
  }

  newQuestion(): void {
    const question = new Question();
    question.answers = [new Answer(), new Answer()];
    this.firstFormGroups.push(this._formBuilder.group({
      questionCtrlName: ['', Validators.required],
      questionCtrlPoints: ['', Validators.required]
    }));
    this.questions.push(question);
    console.log(this.questions);
  }

  removeQuestion(question: Question): void {
    this.questions.splice(this.questions.indexOf(question), 1);
    console.log(this.questions.length);
  }

  addAnswer(question: Question): void {
    this.secondFormGroups.push(this._formBuilder.group({
      answerCtrlName: ['', Validators.required]
    }));
    question.answers.push(new Answer());
  }

  setQuestionPoints(value: string, question: Question) {
    this.questions[this.questions.indexOf(question)].points = Number(value);
  }
}
