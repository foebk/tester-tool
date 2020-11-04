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

  constructor(private http: HttpClient) {
    this.httpClient = http;
  }

  ngOnInit(): void {
  }

  getTest(): void {
    this.http.post('http://localhost:8080/getTest', this.testId)
      .subscribe((test: Test) => {
        this.test = test;
        console.log(test);
      });
    console.log(this.test);
  }
}
