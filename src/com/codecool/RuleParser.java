package codecool;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class RuleParser extends XMLParser {

    private RuleRepository ruleRepository;


    // Constructor(s)
    public RuleParser() {
        ruleRepository = new RuleRepository();
    }


    // Getter(s)
    public RuleRepository getRuleRepository() {
        return ruleRepository;
    }


    // XMLParser method(s)
    @Override
    public void readElementsFromXml(String xmlPath) {
        loadXmlDocument(xmlPath);

        try {
            NodeList nodeList = document.getElementsByTagName("Rule");

            for (int r = 0; r < nodeList.getLength(); r++) {
                // Root node
                Node rule = nodeList.item(r);
                Element ruleE = (Element) rule;
                String questionId = ruleE.getAttribute("id");

                // Get question from Rule
                Element questionE = (Element) ruleE.getElementsByTagName("Question").item(0);
                String questionText = questionE.getTextContent();

                // Get answer from Rule
                Element answerE = (Element) ruleE.getElementsByTagName("Answer").item(0);
                Answer answer = new Answer();

                NodeList selections = answerE.getElementsByTagName("Selection");

                for (int s = 0; s < selections.getLength(); s++) {
                    // Root Element
                    Element selection = (Element) selections.item(s);

                    // Get selectionType
                    boolean selectionType = selection.getAttribute("value").equals("true");

                    // Get inputPattern
                    // TODO: Should check if there's a Single or Multiple -Value...
                    Element valueE = (Element) selection.getElementsByTagName("SingleValue").item(0);
                    String inputPattern = valueE.getAttribute("value");

                    // Build value
                    Value value = new SingleValue(inputPattern, selectionType);

                    answer.addValue(value);
                }

                ruleRepository.addQuestion(
                        new Question(questionId, questionText, answer)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
