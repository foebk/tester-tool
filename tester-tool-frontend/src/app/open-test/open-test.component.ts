import { Component, OnInit } from '@angular/core';
import {Test} from '../models/test';
import {HttpClient} from '@angular/common/http';

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

  constructor(private http: HttpClient) {
    this.httpClient = http;
  }

  ngOnInit(): void {
  }

  getTest(): void {
    console.log(this.testId);
    this.http.post('http://localhost:8080/getTest', this.testId)
      .subscribe((test: Test) => {
        this.test = test;
        console.log(test);
      });
    if (this.test == null || this.test == undefined) {
      this.errorText = "Неправильный UUID. Тест не найден";
    }
    else {
      this.errorText = null;
    }
  }
}
