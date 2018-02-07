package codecool;

public class ESProvider {

    FactParser factParser;
    RuleParser ruleParser;


    // Constructor(s)
    public ESProvider(FactParser factParser, RuleParser ruleParser) {
        this.factParser = factParser;
        this.ruleParser = ruleParser;
    }


    // Getter(s)
    public boolean getAnswerByQuestion(String questionId) {
        return true;
    }


    // ESProvider method(s)
    public void collectAnswers() {

    }

    public String evaluate() {
        return "";
    }
}
