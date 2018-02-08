package codecool;

import java.util.LinkedList;
import java.util.List;

public class SingleValue extends Value {

    private boolean selectionType;

    public SingleValue(String param, boolean selectionType) {
        inputPattern = new LinkedList<String>();
        inputPattern.add(param);
        this.selectionType = selectionType;
    }

    public List<String> getInputPattern() {
        return inputPattern;
    }

    public boolean getSelectionType() {
        return selectionType;
    }

    public boolean isEqual(Value value) {
        for (String pattern : inputPattern) {
            if (!value.getInputPattern().contains(pattern)) {
                return false;
            }

        }
        return true;
    }
}