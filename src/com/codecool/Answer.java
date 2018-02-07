package codecool;

import java.util.List;

public class Answer {

    private List<Value> values;

    public void addValue(Value value) {
        values.add(value);
    }

    public Answer(List<Value> values) {
        this.values = values;
    }

    public List<Value> getValues() {
        return values;
    }

    public boolean evaluateAnswerByInput(String input) throws Exception {
        input = input.toLowerCase();
        if (input.equals("yes")) {
            return true;
        } else if (input.equals("no")) {
            return false;
        }
        throw new Exception("Wrong input");
    }
}