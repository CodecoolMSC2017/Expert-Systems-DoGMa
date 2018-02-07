package codecool;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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
        return facts.get(index++);
    }

    public void remove() {
        // Just here... Don't mind me...
    }
}
