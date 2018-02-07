package codecool;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class QuestionIterator implements Iterator<Question> {
    private List<Question> questions;
    private int index = 0;

    public QuestionIterator(List<Question> questions) {
        this.questions = questions;
    }

    public boolean hasNext() {
        return index < questions.size();
    }

    public Question next() {
        return questions.get(index++);
    }

    public void remove() {
        // Just here... Don't mind me...
    }
}
