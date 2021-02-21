import { Component, OnInit } from '@angular/core';
import {Test} from '../models/test';
import {HttpClient} from '@angular/common/http';
import {TestRequest} from "../models/testRequest";
import {QuestionRequest} from "../models/questionRequest";

@Component({
  selector: 'app-open-test',
  templateUrl: './open-test.component.html',
  styleUrls: ['./open-test.component.css']
})
export class OpenTestComponent implements OnInit {
  test: Test;
  httpClient: HttpClient;
  testId: string;
  errorText: string;
  testRequest: TestRequest;

  constructor(private http: HttpClient) {
    this.httpClient = http;
  }

  ngOnInit(): void {
  }

  getTest(): void {
    if (this.testId == null || this.testId == "") {
      this.errorText = "ID не задан. Введите ID."
    }
    else {
      console.log(this.testId);
      this.http.post('http://localhost:8080/getTest', this.testId)
        .subscribe((test: Test) => {
          this.test = test;
          if (this.test == null) {
            this.errorText = "Неправильный UUID. Тест не найден";
            return;
          } else {
            this.errorText = null;
          }
          console.log(test);
          this.testRequest = new TestRequest();
          this.testRequest.additionalFields = new Map();
          this.testRequest.questions = new Map();
          this.test.questions.forEach(question => {
            var questionRequest = new QuestionRequest();
            questionRequest.answers = new Map();
            questionRequest.id = question.id
            question.answers.forEach(answer => {
              questionRequest.answers.set(answer.id, false);
            })
            this.testRequest.questions.set(question.id, questionRequest);
          })
          console.log(this.testRequest)
        });
    }
  }
}
