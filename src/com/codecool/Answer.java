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
        for (Value value : values) {
            if (value.getInputPattern().contains(input)) {
                return value.getSelectionType();
            }
        }
        throw new Exception("Wrong input");
    }


    public boolean isEqual(Answer a) {
        for (Value value : values) {
            if(!checkValues(value,a)){
                return false;
            }
        }
        return true;
    }
    private boolean checkValues(Value thisValue, Answer answer){
        for(Value otherValue : answer.getValues()){
            if(thisValue.isEqual(otherValue)){
                return true;
            }
        }
        return false;
    }
}