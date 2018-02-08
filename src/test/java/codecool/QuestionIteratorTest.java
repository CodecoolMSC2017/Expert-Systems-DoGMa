package codecool;

import codecool.Rule.question.Answer;
import codecool.Rule.question.Question;
import codecool.Rule.RuleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class QuestionIteratorTest {

    private Iterator<Question> iterator;
    private RuleRepository rulers;

    @BeforeEach
    void setUp() {
        rulers = new RuleRepository();
        iterator = rulers.getIterator();
    }

    @Test
    void hasNext() {
        assertFalse(iterator.hasNext());
        rulers.addQuestion(new Question("test1", "testQuestion1", new Answer()));
        assertTrue(iterator.hasNext());
    }

    @Test
    void next() {

        Question question1 = new Question("questionnumber1", "Question1?", new Answer());
        Question question2 = new Question("questionnumber2","Question2?", new Answer());
        rulers.addQuestion(question1);
        rulers.addQuestion(question2);
        assertEquals(iterator.next(),question1);
        assertEquals(iterator.next(),question2);

    }
}