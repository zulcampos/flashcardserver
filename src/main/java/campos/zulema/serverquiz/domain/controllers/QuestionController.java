package campos.zulema.serverquiz.domain.controllers;

import campos.zulema.serverquiz.domain.exceptions.QuestionCreationException;
import campos.zulema.serverquiz.domain.exceptions.QuestionNotFoundException;
import campos.zulema.serverquiz.domain.model.Question;
import campos.zulema.serverquiz.domain.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/question")
public class QuestionController {
    private QuestionService service;

    @Autowired
    public QuestionController(QuestionService service){
        this.service = service;
    }
    @PostMapping("")
    public ResponseEntity<Question> create(@RequestBody Question question)throws QuestionCreationException {
        question = service.createQuestion(question);
        return new ResponseEntity(question, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws QuestionNotFoundException {
        service.deleteQuestion(id);
        return ResponseEntity.ok().body(null);
    }

    @PutMapping("")
    public ResponseEntity<?> updateQuestion(@RequestBody Question question)throws QuestionNotFoundException{
        question = service.updateQuestion(question);
        return new ResponseEntity<>(question,HttpStatus.ACCEPTED);
    }

}
