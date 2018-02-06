package codecool;

import java.util.Iterator;
import java.util.LinkedList;

public class FactIterator implements Iterator<Fact> {

    private LinkedList<Fact> facts;
    private int index = 0;

    public FactIterator(LinkedList<Fact> facts) {
        this.facts = facts;
    }

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
