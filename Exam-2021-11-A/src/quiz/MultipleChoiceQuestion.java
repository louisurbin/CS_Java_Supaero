package quiz;

public class MultipleChoiceQuestion extends SingleChoiceQuestion {

    public MultipleChoiceQuestion(String questionText) {
        super(questionText);
    }

    public boolean isValid() {
        return this.nbRightAnswers() >= 2;
    }
}
