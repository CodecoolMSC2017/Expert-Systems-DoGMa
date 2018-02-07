package codecool;

public class Main {
    public static void main(String[] args) {
        System.out.println();


        FactParser fp = new FactParser();
        RuleParser rp = new RuleParser();

        ESProvider esp = new ESProvider(fp, rp);
        esp.factParser.loadXmlDocument("src/com/codecool/data/series.xml");
    }
}
