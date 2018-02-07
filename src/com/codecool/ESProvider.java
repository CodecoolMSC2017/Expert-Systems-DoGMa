package codecool;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ESProvider {

    private FactParser factParser;
    private RuleParser ruleParser;

    private Map<String, Boolean> preferences;


    // Constructor(s)
    public ESProvider(FactParser factParser, RuleParser ruleParser) {
        this.factParser = factParser;
        this.ruleParser = ruleParser;
        preferences = new HashMap<String, Boolean>();
    }


    // Getter(s)                                   length
    public boolean getAnswerByQuestion(String questionId) {
        return preferences.get(questionId);
    }


    // ESProvider method(s)
    public void collectAnswers() {
        Iterator<Question> questions = ruleParser.getRuleRepository().getIterator();

        while (questions.hasNext()) {
            Question question = questions.next();
            while(true) {
                try {
                    Scanner input = new Scanner(System.in);
                    question.askUser();
                    boolean evaluatedAsnwer = question.getEvaluatedAsnwer(input.nextLine());
                    preferences.put(question.getId(), evaluatedAsnwer);

                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(evaluate());
    }

    public String evaluate() {
        Iterator<Fact> facts = factParser.getFactRepository().getIterator();
        String chosenSeries = "";

        while (facts.hasNext()) {
            Fact fact = facts.next();
            try {
                for (Map.Entry<String, Boolean> genre : fact.getGenres().entrySet()) {

                    if (genre.getValue() != preferences.get(genre.getKey())) {
                        throw new Exception("The user won't like this.");
                    }
                }
                chosenSeries += fact.getDescription() + "\n";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return chosenSeries;
    }
}
