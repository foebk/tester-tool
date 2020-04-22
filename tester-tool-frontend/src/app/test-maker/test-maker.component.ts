import {Component, OnInit} from '@angular/core';
import {Question} from '../models/question';
import {Answer} from '../models/answer';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Test} from '../models/test';

@Component({
  selector: 'app-test-maker',
  templateUrl: './test-maker.component.html',
  styleUrls: ['./test-maker.component.css']
})
export class TestMakerComponent implements OnInit {

  questions: Question[];
  firstFormGroups: FormGroup[];
  secondFormGroups: FormGroup[];
  test: Test = new Test();
  additField: string;

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
    this.secondFormGroups.push(this._formBuilder.group({
      firstAnswer: ['', Validators.required],
      secondAnswer: ['', Validators.required]
    }));
    question.tempAnswers = [];
    this.questions.push(question);
    console.log(this.questions);
    console.log((this.test));
  }

  removeQuestion(question: Question): void {
    this.questions.splice(this.questions.indexOf(question), 1);
  }

  addAnswer(question: Question): void {
    question.tempAnswers.push(new Answer());
  }

  setQuestionPoints(value: string, question: Question) {
    this.questions[this.questions.indexOf(question)].points = Number(value);
  }

  addField(value: string) {
    if (this.test.additionalFields.length < 10 && value.length !== 0) {
      this.test.additionalFields.push(value);
      this.additField = '';
    }
  }
}
