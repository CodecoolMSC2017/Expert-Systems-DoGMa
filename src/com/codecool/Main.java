package codecool;

import codecool.DataService.FactParser;
import codecool.DataService.RuleParser;

public class Main {
    public static void main(String[] args) {

        FactParser fp = new FactParser("src/com/codecool/data/series.xml");
        RuleParser rp = new RuleParser("src/com/codecool/data/questions.xml");

        ESProvider esp = new ESProvider(fp, rp);

        esp.collectAnswers();
    }
}
