package codecool;

// XML Structure
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import java.io.IOException;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FactParser extends XMLParser {

    @Override
    public LinkedList<Fact> loadXmlDocument (String xmlPath) {
        LinkedList<Fact> facts = new LinkedList<Fact>();

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document document = dBuilder.parse(new File(xmlPath));

            NodeList nodeList = document.getElementsByTagName("Fact");

            for (int i = 0; i < nodeList.getLength(); i++) {
                // Holds the Description and the Evals
                Node fact = nodeList.item(i);
                NodeList factsChildren = fact.getChildNodes();

                HashMap<String, Boolean> genres = new HashMap<String, Boolean>();
                // Evals
                NodeList evals = factsChildren.item(1).getChildNodes();
                for (int e = 0; e < evals.getLength(); e++) {
                    genres.put(
                            ((Element)evals.item(e)).getAttribute("id"),
                            evals.item(e).getTextContent().equals("true")
                            );
                }
                
                facts.add(new Fact(
                        ((Element) fact).getAttribute("id"),
                        factsChildren.item(0).getNodeValue(),
                        genres
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return facts;
    }

    public void printFacts (LinkedList<Fact> facts) {
        System.out.println(facts.size());
        for (Fact fact : facts) {
            System.out.println(fact.getId());
            System.out.println(fact.getDescription());
            fact.printGenres();
        }
    }

    public FactRepository getFactRepository(){
        return null;
    }
}
