import {QuestionResultModel} from "./questionResultModel";
import {AdditionalFieldResponse} from "./additionalFieldResponse";

export class ResultModel {
  percentage: number
  correctAnswers: number
  points: number
  pointsTotal: number
  questionResults: QuestionResultModel[]
  additionalFields: AdditionalFieldResponse[]
}
