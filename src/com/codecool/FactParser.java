package codecool;

import org.w3c.dom.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class FactParser extends XMLParser {

    private FactRepository factRepository;


    // Constructor(s)
    public FactParser(String xmlPath) {
        this.xmlPath = xmlPath;
        factRepository = new FactRepository();
        readElementsFromXml();
    }


    // Getter(s)
    public FactRepository getFactRepository() {
        return factRepository;
    }


    // XMLParser method(s)
    @Override
    public void readElementsFromXml() {
        loadXmlDocument();

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
                factRepository.addFact(
                        new Fact(id, description, genres)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
