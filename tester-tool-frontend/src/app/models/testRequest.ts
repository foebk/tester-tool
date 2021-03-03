import {QuestionRequest} from "./questionRequest";
import {AdditionalFieldRequest} from "./additionalFieldRequest";

export class TestRequest {
  id: String;
  additionalFields: Map<String, AdditionalFieldRequest>
  questions: Map<String, QuestionRequest>
}
