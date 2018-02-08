package codecool;

import org.junit.jupiter.api.function.Executable;

import javax.swing.text.html.HTMLDocument;

import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class FactIteratorTest {
    private FactRepository factRepository;
    private Iterator<Fact> iterator;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        factRepository = new FactRepository();
        iterator = factRepository.getIterator();
    }

    @org.junit.jupiter.api.Test
    void hasNext() {

        assertFalse(iterator.hasNext());
        HashMap<String, Boolean> genres = new HashMap<String, Boolean>();
        genres.put("length", true);
        factRepository.addFact(new Fact("testfactid", "testfact1", genres));
        assertTrue(iterator.hasNext());
    }

    @org.junit.jupiter.api.Test
    void next() {
        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, () -> iterator.next());
    }
}