import {QuestionRequest} from "./questionRequest";
import {AdditionalFieldRequest} from "./additionalFieldRequest";

export class TestRequest {
  id: String
  additionalFields: AdditionalFieldRequest[]
  questions: QuestionRequest[]
}
