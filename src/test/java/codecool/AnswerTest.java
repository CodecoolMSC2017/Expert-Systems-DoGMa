package codecool;

import codecool.Rule.question.Answer;
import codecool.Rule.question.SingleValue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class AnswerTest {
    Answer a = new Answer();

    @BeforeEach
    void setUp() {
        a.addValue(new SingleValue("yes", true));
        a.addValue(new SingleValue("no", false));
    }

    @Test
    void evaluateAnswerByInputTest() throws Exception {
        assertTrue( a.evaluateAnswerByInput("yes"));
        assertFalse( a.evaluateAnswerByInput("no"));
    }
}