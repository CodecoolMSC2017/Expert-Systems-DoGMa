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


    // Question method(s)
    public boolean getEvaluatedAnswer(String input) throws Exception {

        return answer.evaluateAnswerByInput(input);
    }

    public void askUser () {
        System.out.println(question);
        for (Value value : answer.getValues()) {
            for (String pattern : value.getInputPattern()) {
                System.out.printf("%s,  ", pattern);
            }
        }
    }
}
