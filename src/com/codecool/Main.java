package codecool;

public class Main {
    public static void main(String[] args) {

        FactParser fp = new FactParser();
        RuleParser rp = new RuleParser();

        ESProvider esp = new ESProvider(fp, rp);

        esp.collectAnswers();
    }
}
