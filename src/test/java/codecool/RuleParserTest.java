package codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class RuleParserTest {
    Question q;
    RuleParser r;
    @BeforeEach
    void setUp() {
        r = new RuleParser("src/com/codecool/data/ruleTest.xml");
        Answer a = new Answer();
        a.addValue(new SingleValue("yes",true));
        a.addValue(new SingleValue("no",false));

        q = new Question("Test","Do you?",a);
    }

    @Test
    void TestreadElementsFromXml() {
      assertTrue(r.getRuleRepository().getIterator().next().isEqual(q));
    }
}