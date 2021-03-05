package testerTool.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import testerTool.entities.QuestionRequestEntity;
import testerTool.models.QuestionRequest;
import testerTool.repos.QuestionsRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuestionRequestToQuestionRequestEntity
        implements Converter<QuestionRequest, QuestionRequestEntity> {
    private final QuestionsRepository questionsRepository;
    private final AnswerRequestToAnswerRequestEntity answerRequestToAnswerRequestEntity;

    public QuestionRequestToQuestionRequestEntity(QuestionsRepository questionsRepository,
                                                  AnswerRequestToAnswerRequestEntity answerRequestToAnswerRequestEntity) {
        this.questionsRepository = questionsRepository;
        this.answerRequestToAnswerRequestEntity = answerRequestToAnswerRequestEntity;
    }

    @Override
    public QuestionRequestEntity convert(QuestionRequest questionRequest) {
        QuestionRequestEntity questionRequestEntity = new QuestionRequestEntity();

        questionRequestEntity.setAnswers(answerRequestToAnswerRequestEntity.convertList(questionRequest.getAnswers()));
        questionRequestEntity.setQuestionEntity(questionsRepository.findById(questionRequest.getId()));

        return questionRequestEntity;
    }

    public List<QuestionRequestEntity> convertList(List<QuestionRequest> questionRequests) {
        return questionRequests.stream().map(this::convert).collect(Collectors.toList());
    }
}
