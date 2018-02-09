package codecool;

import codecool.Fact.Fact;
import codecool.DataService.FactParser;
import codecool.Rule.question.Question;
import codecool.DataService.RuleParser;

import java.io.IOException;
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
    public void addPreference(String questionId,boolean answer){
        preferences.put(questionId,answer);
    }

    // ESProvider method(s)
    public void collectAnswers() throws IOException {
        factParser.getFactRepository().printFactCollectionNumber();
        Iterator<Question> questions = ruleParser.getRuleRepository().getIterator();

        while (questions.hasNext()) {
            Question question = questions.next();
            while (true) {
                try {
                    Scanner input = new Scanner(System.in);
                    question.askUser();
                    boolean evaluatedAsnwer = question.getEvaluatedAnswer(input.nextLine());
                    addPreference(question.getId(), evaluatedAsnwer);

                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(evaluate());
    }



    public String evaluate() throws IOException {
        Iterator<Fact> facts = factParser.getFactRepository().getIterator();
        String chosenSeries = "";

        while (facts.hasNext()) {
            Fact fact = facts.next();
            try {
                for (Map.Entry<String, Boolean> genre : fact.getGenres().entrySet()) {


                    if (genre.getValue() != getAnswerByQuestion(genre.getKey())) {
                        throw new Exception("The user won't like this.");
                    }
                }
                chosenSeries += fact.getDescription() + "\n";
            } catch (Exception e) {
            }
        }
        urlOpener(chosenSeries);
        return chosenSeries.equals("") ? "Series not found!" : chosenSeries;
    }

    public void urlOpener(String url) throws IOException {
        Runtime rt = Runtime.getRuntime();
        rt.exec("open " + url);

    }

}
