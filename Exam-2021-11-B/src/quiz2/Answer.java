package quiz2;

public class Answer {
    private String text;
    private double percent;


    public Answer(String text, double percent) {
        if(0 > percent || 100 < percent || text == "" || text == null){
            System.err.println("erreur création");
        }
        else{
            this.text = text;
            this.percent = percent;
        }
    }

    public String getText() {
        return this.text;
    }

    public double getPercent() {
        return this.percent;
    }

}
