package codecool;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FactRepository {

    private List<Fact> facts;
    private FactIterator factIterator;


    // Constructor(s)
    public FactRepository() {
        facts = new LinkedList<Fact>();
        factIterator = new FactIterator(facts);
    }


    // Getter(s)
    public Iterator<Fact> getIterator() {
        return factIterator;
    }


    // FactRepository method(s)
    public void addFact(Fact fact) {
        facts.add(fact);
    }
}
