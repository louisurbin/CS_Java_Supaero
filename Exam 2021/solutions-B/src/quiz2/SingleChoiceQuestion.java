package quiz2;

public class SingleChoiceQuestion extends MultipleChoiceQuestion {

    public SingleChoiceQuestion(String questionText) {
        super(questionText);
    }

    @Override
    public boolean isValid() {
        int nbNonZero = 0;
        for(Answer a: answers) {
            if(a.getPercent() != 0) {
                nbNonZero++;
            }
        }
        return nbNonZero == 1 && super.isValid();
    }
    
}
