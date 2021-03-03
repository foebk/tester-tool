import { Component, OnInit } from '@angular/core';
import {Test} from '../models/test';
import {HttpClient} from '@angular/common/http';
import {TestRequest} from "../models/testRequest";
import {QuestionRequest} from "../models/questionRequest";
import {AdditionalFieldRequest} from "../models/additionalFieldRequest";
import {AdditionalField} from "../models/additionalField";

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
  errorTextSendResult: string;
  fieldsMap: Map<string, string>;
  isSent: boolean;

  constructor(private http: HttpClient) {
    this.httpClient = http;
  }

  ngOnInit(): void {
    this.isSent = false
  }

  getTest(): void {
    if (this.testId == null || this.testId == "") {
      this.errorText = "ID не задан. Введите ID."
    }
    else {
      this.http.post('http://localhost:8080/getTest', this.testId)
        .subscribe((test: Test) => {
          this.test = test;
          if (this.test == null) {
            this.errorText = "Неправильный UUID. Тест не найден";
            return;
          } else {
            this.errorText = null;
          }
          this.fieldsMap = new Map<string, string>();
          this.test.additionalFields.forEach(field => this.fieldsMap.set(field.id, field.name))
          this.testRequest = new TestRequest();
          this.testRequest.additionalFields = new Map();
          this.test.additionalFields.forEach(field => {
            this.testRequest.additionalFields.set(field.id, new AdditionalFieldRequest(field.id, null))
          })
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
          this.testRequest.id = this.testId
        });
    }
  }

  changeField(value: string, field: AdditionalField) {
    this.testRequest.additionalFields.get(field.id).value = value
  }

  sendRequest(): void {
    console.log(this.testRequest)
    this.errorTextSendResult = null;
    var errorFields = [];
    this.testRequest.additionalFields.forEach((value, key) => {
      var field = this.testRequest.additionalFields.get(key);
      if (field.value == null || field.value == "") {
        errorFields.push(this.fieldsMap.get(field.id));
      }
    })
    if (errorFields.length != 0) {
      this.errorTextSendResult = "Заполните оставшиеся поля: "
      errorFields.forEach(error => {
        this.errorTextSendResult = this.errorTextSendResult + "\"" + error + "\", "
      })
      this.errorTextSendResult = this.errorTextSendResult.slice(0, this.errorTextSendResult.length - 2);
    }
    else {
      this.http.post('http://localhost:8080/getResult', this.testRequest)
        .subscribe(() => { this.isSent = true;
        });
    }
  }
}
