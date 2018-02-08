package codecool.Fact;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class FactIterator implements Iterator<Fact> {

    private List<Fact> facts;
    private int index = 0;


    // Constructor(s)
    public FactIterator(List<Fact> facts) {
        this.facts = facts;
    }


    // Iterator method(s)
    public boolean hasNext() {
        return index < facts.size();
    }

    public Fact next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return facts.get(index++);
    }

    public void remove() {
        // Just here... Don't mind me...
    }
}
