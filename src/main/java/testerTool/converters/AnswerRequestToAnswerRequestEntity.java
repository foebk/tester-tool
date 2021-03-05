package testerTool.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import testerTool.entities.AnswerRequestEntity;
import testerTool.models.AnswerRequest;
import testerTool.repos.AnswersRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AnswerRequestToAnswerRequestEntity
        implements Converter<AnswerRequest, AnswerRequestEntity> {
    private final AnswersRepository answersRepository;

    public AnswerRequestToAnswerRequestEntity(AnswersRepository answersRepository) {
        this.answersRepository = answersRepository;
    }

    @Override
    public AnswerRequestEntity convert(AnswerRequest answerRequest) {
        AnswerRequestEntity answerRequestEntity = new AnswerRequestEntity();

        answerRequestEntity.setMark(answerRequest.isCorrect());
        answerRequestEntity.setAnswer(answersRepository.findById(answerRequest.getId()));

        return answerRequestEntity;
    }

    public List<AnswerRequestEntity> convertList(List<AnswerRequest> answerRequests) {
        return answerRequests.stream().map(this::convert).collect(Collectors.toList());
    }
}
