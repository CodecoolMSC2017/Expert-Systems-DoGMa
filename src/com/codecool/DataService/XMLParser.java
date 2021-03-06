package codecool.DataService;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.LinkedList;

public abstract class XMLParser {

    protected Document document;
    protected String xmlPath;

    protected void loadXmlDocument() {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            document = dBuilder.parse(new File(xmlPath));
        } catch (Exception e) {}
    }

    protected abstract void readElementsFromXml ();
}
