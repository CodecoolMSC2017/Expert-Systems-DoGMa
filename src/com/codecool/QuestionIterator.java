package codecool;

import java.util.Iterator;
import java.util.LinkedList;

public class QuestionIterator implements Iterator<Question> {
    private LinkedList<Question> questions;
    private int index = 0;

    public QuestionIterator(LinkedList<Question> questions) {
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
