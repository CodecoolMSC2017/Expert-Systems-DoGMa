package codecool;

import java.util.LinkedList;
import java.util.List;

public abstract class Value {

    protected List<String> inputPattern;

    public Value() {
        inputPattern = new LinkedList<String>();
    }

    public abstract List<String> getInputPattern();

    public abstract boolean getSelectionType();
}
