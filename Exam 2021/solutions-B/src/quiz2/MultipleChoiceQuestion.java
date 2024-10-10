package quiz2;

import java.util.ArrayList;

public class MultipleChoiceQuestion extends AbstractQuestion {
    private String questionText;
    protected ArrayList<Answer> answers;

    public MultipleChoiceQuestion(String questionText) {
        this.questionText = questionText;
        this.answers = new ArrayList<>();
    }

    public void addAnswer(Answer a) {
        answers.add(a);
    }

    public double answersPercentsSum() {
        double sum = 0;
        for(Answer a: answers) {
            sum += a.getPercent();
        }
        return sum;
    }

    public boolean isValid() {
        return answersPercentsSum() == 100;
    }

    public void showToStudent() {
        System.out.println(questionText);
        int frontNumber = 1;
        for(Answer a: answers) {
            System.out.printf("   %d. %s\n", frontNumber, a.getText());
            frontNumber++;
        }
    }

    public void showToTeacher() {
        System.out.println(questionText);
        int frontNumber = 1;
        for(Answer a: answers) {
            System.out.printf("%.1f\t%d. %s\n", a.getPercent(), frontNumber, a.getText());
            frontNumber++;
        }
    }

}