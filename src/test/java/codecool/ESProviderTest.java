package codecool;

import codecool.DataService.FactParser;
import codecool.DataService.RuleParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ESProviderTest {
    FactParser f;
    ESProvider e;
    RuleParser r;
    @BeforeEach
    void setUp() throws IOException, InterruptedException {
        f = new FactParser("src/com/codecool/data/test.xml");
        r = new RuleParser("src/com/codecool/data/questions.xml");
        e = new ESProvider(f, r);
        e.addPreference("length", true);
        e.addPreference("animation", true);
        e.addPreference("comedy", true);
        e.addPreference("horror", true);
        e.addPreference("drama", true);
        e.addPreference("action", true);
        e.addPreference("scifi", true);
    }

    @Test
    void TestEvaluate() throws IOException, InterruptedException {
        assertEquals("Test\n",e.evaluate());
        assertFalse("Dako"==e.evaluate());
    }
}