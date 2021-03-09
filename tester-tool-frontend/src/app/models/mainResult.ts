import {ResultModel} from "./resultModel";
import {QuestionRating} from "./questionRating";

export class MainResult {
  testName: string;
  testDescription: string;
  averagePoints: number;
  lowestPoints: number;
  highestPoints: number;
  averagePercentage: number;
  lowestPercentage: number;
  highestPercentage: number;
  resultModels: ResultModel[];
  questionRatings: QuestionRating[];
}
