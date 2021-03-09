import { Component, OnInit } from '@angular/core';
import {MainResult} from "../models/mainResult";
import {HttpClient} from "@angular/common/http";
import {MatTabsModule} from '@angular/material/tabs';
import {Test} from "../models/test";

@Component({
  selector: 'app-get-result',
  templateUrl: './get-result.component.html',
  styleUrls: ['./get-result.component.css']
})
export class GetResultComponent implements OnInit {
  mainResult: MainResult;
  httpClient: HttpClient;
  testId: string;
  errorText: string;

  constructor(private http: HttpClient) {
    this.httpClient = http;
  }

  ngOnInit(): void {
  }

  getTestResult(): void {
    if (this.testId == null || this.testId == "") {
      this.errorText = "ID не задан. Введите ID."
    } else {
      this.http.get('http://localhost:8080/getAllResults?id=' + this.testId)
        .subscribe((res: MainResult) => {
          console.log(res);
          this.mainResult = res;
          if (this.mainResult == null) {
            this.errorText = "Неправильный UUID. Тест не найден";
            return;
          } else {
            this.errorText = null
          }
        })
    }
  }
}
