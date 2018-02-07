package codecool;

public class Question {
    private String id;
    private String question;
    private Answer answer;


    // Constructor(s)
    public Question(String id, String question, Answer answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }


    // Getter(s)
    public String getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public Answer getAnswer() {
        return answer;
    }


    // Setter(s)
    public void setId(String id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }


    // Question method(s)
    public boolean getEvaluatedAsnwer(String input) throws Exception {

        return answer.evaluateAnswerByInput(input);
    }
}
