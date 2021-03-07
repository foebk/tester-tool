import {QuestionResultModel} from "./questionResultModel";

export class ResultModel {
  percentage: number
  correctAnswers: number
  points: number
  pointsTotal: number
  questionResults: QuestionResultModel[]
}
