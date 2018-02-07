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
                // Root node
                Node rule = nodeList.item(r);
                Element ruleE = (Element) rule;

                // Get question from Rule
                Element questionE = (Element) ruleE.getElementsByTagName("Question").item(0);
                String questionId = questionE.getAttribute("id");
                String questionText = questionE.getTextContent();

                // Get answer from Rule
                Element answerE = (Element) ruleE.getElementsByTagName("Answer").item(0);
                // Read the selection values...

                NodeList selections = answerE.getElementsByTagName("Selection");

                for (int s = 0; s < selections.getLength(); s++) {
                    System.out.println(s);
                }

                Question question = new Question(
                        questionId,
                        questionText,
                        new Answer()
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
