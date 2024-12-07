package quiz;

public class QuestionsMain {
    public static void main(String[] args) {

        Answer a1 = new Answer("0", false);
        Answer a2 = new Answer("12", true);

        SingleChoiceQuestion single = new SingleChoiceQuestion("Combien de groupes de TD y a-t-il en deuxième année ?");
        single.addAnswer(a1);
        single.addAnswer(a2);
        single.showToStudent();
        single.showToTeacher();

        MultipleChoiceQuestion multiple = new MultipleChoiceQuestion(
                "Quels mot-clés Java sont directement liés au sous-typage ?");
        multiple.addAnswer(new Answer("interface", true));
        multiple.addAnswer(new Answer("extends", true));
        multiple.addAnswer(new Answer("implements", true));
        multiple.addAnswer(new Answer("while", false));
        multiple.showToStudent();
        multiple.showToTeacher();
    }
}
