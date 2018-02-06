package codecool;

public class ESProvider {

    FactParser factParser;
    RuleParser ruleParser;

    public ESProvider(FactParser factParser,RuleParser ruleParser){
        this.factParser = factParser;
        this.ruleParser = ruleParser;
    }

    public void collectAnswers(){

    }

    public boolean getAnswerByQuestion(String questionId){
        return true;
    }

    public String evaluate(){
        return "";
    }
}
