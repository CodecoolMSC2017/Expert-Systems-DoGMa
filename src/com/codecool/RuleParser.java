package codecool;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.LinkedList;

public class RuleParser extends XMLParser {

    LinkedList<Question> questions;

    public RuleRepository getRuleRepository(){
        return null;
    }

    @Override
    public void readElementsFromXml(String xmlPath){
        loadXmlDocument(xmlPath);

        try {
            NodeList nodeList = document.getElementsByTagName("Rule");

            for (int r = 0; r < nodeList.getLength(); r++) {
                Node rule = nodeList.item(r);
                Element ruleE = (Element) rule;

                Element questionE = (Element) ruleE.getElementsByTagName("Question").item(0);


                Element answerE = (Element) ruleE.getElementsByTagName("Answer").item(0);
                // Read the selection values...

                answerE.getElementsByTagName("Selection");

                Question question = new Question(
                        questionE.getAttribute("id"),
                        questionE.getTextContent(),
                        new Answer()
                );
            }
            // Code here



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
