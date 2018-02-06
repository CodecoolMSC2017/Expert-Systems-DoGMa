package codecool;

public class Main {
    public static void main(String[] args) {
        System.out.println();

        FactParser fp = new FactParser();
        fp.printFacts(fp.loadXmlDocument("src/com/codecool/data/series.xml"));
    }
}
