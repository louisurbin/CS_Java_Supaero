package quiz2;

import java.util.ArrayList;

public class MultipleChoiceQuestion extends AbstractQuestion{
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
        double s = 0;
        for(Answer a : answers){
            s += a.getPercent();
        }
        return s;
    }

    public boolean isValid() {
        return answersPercentsSum() == 100;
    }

    public void showToStudent(){
        String str = this.questionText;
        for(int i=0; i<answers.size(); i++){
            str += "\n" + (i+1) + ". "+ this.answers.get(i).getText();
        }
        System.out.println(str);
    }

    public void showToTeacher(){
        String str = this.questionText;
        for(int i=0; i<answers.size(); i++){
            str += "\n" + this.answers.get(i).getPercent() + " " + (i+1) + ". "+ this.answers.get(i).getText(); 
        }
        System.out.println(str);
    }

}