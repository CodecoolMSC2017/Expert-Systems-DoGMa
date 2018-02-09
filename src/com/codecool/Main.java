package codecool;

import codecool.DataService.FactParser;
import codecool.DataService.RuleParser;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        FactParser fp = new FactParser("src/com/codecool/data/series.xml");
        RuleParser rp = new RuleParser("src/com/codecool/data/questions.xml");

        ESProvider esp = new ESProvider(fp, rp);

        esp.collectAnswers();
    }
}
