package codecool;

import codecool.Fact.Fact;
import codecool.DataService.FactParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class FactParserTest {
    FactParser fp;

    @BeforeEach
    void setUp() {
       fp = new FactParser("src/com/codecool/data/test.xml");
    }


    @Test
    void TestreadElementsFromXml() {
        HashMap<String, Boolean> genres = new HashMap<String,Boolean>();
        genres.put("length",true);
        genres.put("comedy",true);
        genres.put("horror",true);
        genres.put("drama",true);
        genres.put("action",true);
        genres.put("scifi",true);
        genres.put("animation",true);
        assertTrue(fp.getFactRepository().getIterator().next().isEqual(new Fact("got","Test",genres)));
    }
}