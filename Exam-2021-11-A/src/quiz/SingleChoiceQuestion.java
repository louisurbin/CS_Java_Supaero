package quiz;

import java.util.ArrayList;

public class SingleChoiceQuestion implements Question {
    private String questionText;
    private ArrayList<Answer> answers;

    public SingleChoiceQuestion(String questionText) {
        if ("".equals(questionText) || questionText == null) {
            throw new IllegalArgumentException("questionText is empty or equals to null");
        }
        this.questionText = questionText;
        this.answers = new ArrayList<>();
    }

    public void addAnswer(Answer a) {
        if (a == null) {
            throw new IllegalArgumentException("Answer should not be null");
        }
        this.answers.add(a);
    }

    public int nbRightAnswers() {
        int nb = 0;
        for (Answer answer : answers) {
            if (answer.isRight()) {
                nb += 1;
            }
        }
        return nb;
    }

    public boolean isValid() {
        return this.nbRightAnswers() == 1;
    }

    public void showToStudent() {
        System.out.println(this.questionText);
        int k = 0;
        for (Answer answer : answers) {
            k++;
            System.out.printf("   %d. %s\n", k, answer.getText());
        }
    }

    public void showToTeacher() {
        System.out.println(this.questionText);
        int k = 0;
        for (Answer answer : answers) {
            if (answer.isRight()) {
                System.out.print("-> ");
            } else {
                System.out.print("   ");
            }
            k++;
            System.out.println(k + ". " + answer.getText());
        }
    }
}