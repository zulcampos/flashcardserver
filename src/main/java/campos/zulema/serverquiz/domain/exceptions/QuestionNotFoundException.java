package campos.zulema.serverquiz.domain.exceptions;

public class QuestionNotFoundException extends Exception{
    public QuestionNotFoundException(String msg){
        super(msg);
    }
}
