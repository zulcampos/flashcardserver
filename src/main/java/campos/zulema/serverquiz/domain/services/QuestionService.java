package campos.zulema.serverquiz.domain.services;

import campos.zulema.serverquiz.domain.exceptions.QuestionCreationException;
import campos.zulema.serverquiz.domain.exceptions.QuestionNotFoundException;
import campos.zulema.serverquiz.domain.model.Question;
import java.util.List;

public interface QuestionService {
    Question createQuestion(Question question)throws QuestionCreationException;
    Question getById(Long id)throws QuestionNotFoundException;
    List<Question> getAllQuestions();
    void deleteQuestion(Long id)throws QuestionNotFoundException;
    Question updateQuestion(Question question)throws QuestionNotFoundException;
}
