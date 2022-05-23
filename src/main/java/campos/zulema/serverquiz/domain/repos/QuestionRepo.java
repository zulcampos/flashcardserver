package campos.zulema.serverquiz.domain.repos;

import campos.zulema.serverquiz.domain.model.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepo extends CrudRepository<Question,Long> {

}
