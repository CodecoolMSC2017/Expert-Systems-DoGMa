package codecool;

import javax.print.attribute.standard.RequestingUserName;

public class Question {
    String id;
    String question;
    Answer answer;

    public Question(String id, String question, Answer answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public String getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public boolean getEvaluatedAsnwer(String input){
        return true;
    }
}
