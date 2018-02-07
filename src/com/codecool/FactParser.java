package codecool;

import org.w3c.dom.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class FactParser extends XMLParser {

    private FactRepository factRepository;

    private LinkedList<Fact> facts;


    // Constructor(s)
    public FactParser() {
        loadXmlDocument("src/com/codecool/data/series.xml");
        factRepository = new FactRepository(facts);
    }


    // Getter(s)
    public FactRepository getFactRepository() {
        return factRepository;
    }


    // XMLParser method(s)
    @Override
    public void readElementsFromXml(String xmlPath) {
        facts = new LinkedList<Fact>();
        loadXmlDocument(xmlPath);

        try {
            NodeList nodeList = document.getElementsByTagName("Fact");

            for (int f = 0; f < nodeList.getLength(); f++) {
                // Root node
                Node fact = nodeList.item(f);
                Element factE = (Element) fact;

                // Get id from fact
                String id = factE.getAttribute("id");

                // Get Description from fact
                String description = ((Element) factE.getElementsByTagName("Description").item(0)).getAttribute("value");

                // Get genres from Evals
                NodeList evals = ((Element) factE.getElementsByTagName("Evals").item(0)).getElementsByTagName("Eval");

                HashMap<String, Boolean> genres = new HashMap<String, Boolean>();
                for (int e = 0; e < evals.getLength(); e++) {
                    genres.put(
                            ((Element) evals.item(e)).getAttribute("id"),
                            ((Element) evals.item(e)).getAttribute("value").equals("true")
                    );
                }

                // Add the fact to facts
                facts.add(new Fact(id, description, genres));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        printFacts(facts);
    }


    // FactParser method(s)
    public void printFacts(List<Fact> facts) {
        for (Fact fact : facts) {
            System.out.println(fact.getId());
            System.out.println(fact.getDescription());
            fact.printGenres();
        }
    }
}
