package codecool;

import java.util.LinkedList;
import java.util.List;

public class Answer {

    private List<Value> values;

    public void addValue(Value value) {
        values.add(value);
    }

    public Answer() {
        values = new LinkedList<Value>();
    }

    public List<Value> getValues() {
        return values;
    }

    public boolean evaluateAnswerByInput(String input) throws Exception {
        if (input.equalsIgnoreCase("yes")) {
            return true;
        } else if (input.equals("no")) {
            return false;
        }
        throw new Exception("Wrong input");
    }
}