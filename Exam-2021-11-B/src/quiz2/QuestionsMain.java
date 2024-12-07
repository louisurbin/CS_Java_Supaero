package quiz2;

public class QuestionsMain {
    public static void main(String[] args) {

        
        MultipleChoiceQuestion multiple = 
            new MultipleChoiceQuestion("Quels mot-clés Java sont directement liés au noyau impératif ?");
        multiple.addAnswer(new Answer("if", 25));
        multiple.addAnswer(new Answer("else", 25));
        multiple.addAnswer(new Answer("while", 25));
        multiple.addAnswer(new Answer("for", 25));
        multiple.addAnswer(new Answer("interface", 0));
        multiple.showToStudent();
        multiple.showToTeacher();
        

        
        SingleChoiceQuestion single = 
            new SingleChoiceQuestion("Combien de salles informatiques y a-t-il au CI ?");
        single.addAnswer(new Answer("0", 0));
        single.addAnswer(new Answer("14", 100));
        single.showToStudent();
        single.showToTeacher();
        System.out.println(single.isValid());
        
    }
}
