package codecool;

import java.util.LinkedList;
import java.util.List;

public class SingleValue extends Value {

    private boolean selectionType;

    public SingleValue(String param, boolean selectionType) {
        inputPattern.add(param);
        this.selectionType = selectionType;
        inputPattern = new LinkedList<String>();
    }

    public List<String> getInputPattern() {
        return null;
    }

    public boolean getSelectionType() {
        return selectionType;
    }
}
