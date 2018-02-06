package codecool;

import org.w3c.dom.*;

import java.util.HashMap;
import java.util.LinkedList;

public class FactParser extends XMLParser {

    LinkedList<Fact> facts = new LinkedList<Fact>();

    @Override
    public void readElementsFromXml(String xmlPath) {

        loadXmlDocument(xmlPath);

        try {
            NodeList nodeList = document.getElementsByTagName("Fact");

            for (int f = 0; f < nodeList.getLength(); f++) {
                // Root node
                Node fact = nodeList.item(f);
                Element factE = (Element) fact;

                // Get id for fact
                String id = factE.getAttribute("id");

                // Get Description for fact
                String description = ((Element) factE.getElementsByTagName("Description").item(0)).getAttribute("value");

                // Get genres for fact
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

    public void printFacts(LinkedList<Fact> facts) {
        for (Fact fact : facts) {
            System.out.println(fact.getId());
            System.out.println(fact.getDescription());
            fact.printGenres();
        }
    }

    public FactRepository getFactRepository() {
        return null;
    }
}
