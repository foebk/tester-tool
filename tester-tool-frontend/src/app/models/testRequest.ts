import {QuestionRequest} from "./questionRequest";

export class TestRequest {
  id: String;
  additionalFields: Map<String, String>
  questions: Map<String, QuestionRequest>
}
