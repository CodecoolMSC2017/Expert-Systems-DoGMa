package codecool;

import java.util.LinkedList;

public abstract class XMLParser {

    public abstract LinkedList<Fact> loadXmlDocument(String xmlPath);
}
