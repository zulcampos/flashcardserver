package campos.zulema.serverquiz.domain.services;

import campos.zulema.serverquiz.domain.exceptions.QuestionCreationException;
import campos.zulema.serverquiz.domain.exceptions.QuestionNotFoundException;
import campos.zulema.serverquiz.domain.model.Question;
import campos.zulema.serverquiz.domain.repos.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService{
    private QuestionRepo repo;
    @Autowired
    public QuestionServiceImpl(QuestionRepo repo){
        this.repo = repo;
    }

    @Override
    public Question createQuestion(Question question) throws QuestionCreationException {
        return repo.save(question);
    }

    @Override
    public Question getById(Long id) throws QuestionNotFoundException {
        Optional<Question> questionOptional = repo.findById(id);
        if(questionOptional.isEmpty())
            throw new QuestionNotFoundException("No question with this id found");
        return questionOptional.get();
    }

    @Override
    public List<Question> getAllQuestions() {
        return (List)repo.findAll();
    }

    @Override
    public void deleteQuestion(Long id) throws QuestionNotFoundException {
        Optional<Question> questionOptional = repo.findById(id);
        if(questionOptional.isEmpty())
            throw new QuestionNotFoundException("Question with this id not found");
        Question questionToDelete =questionOptional.get();
        repo.delete(questionToDelete);

    }

    @Override
    public Question updateQuestion(Question question) throws QuestionNotFoundException {
        Long id = question.getId();
        Optional<Question> questionOptional = repo.findById(id);
        if(questionOptional.isEmpty())
            throw new QuestionNotFoundException("Question with id not found");
        return repo.save(question);
    }
}
