package codecool;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RuleRepository {

    private List<Question> questions;
    private QuestionIterator questionIterator;


    // Constructor(s)
    public RuleRepository() {
        questions = new LinkedList<Question>();
        questionIterator = new QuestionIterator(questions);
    }


    // Getter(s)
    public Iterator<Question> getIterator() {
        return questionIterator;
    }


    // RuleRepository method(s)
    public void addQuestion(Question question) {
        questions.add(question);
    }
}
