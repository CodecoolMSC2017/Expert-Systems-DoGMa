package codecool.Fact;

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

    public void printFactCollectionNumber() {
        System.out.printf("There are a total of %s series in our collection!\n", facts.size());
    }
}
