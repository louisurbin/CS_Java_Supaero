package quiz2;

public class Answer {

    private String text;
    private double percent;

    public Answer(String text, double percent) {
        if(text == null || text.trim().equals("")) {
            throw new IllegalArgumentException("Answer text should not be null nor empty");
        }
        if(percent < 0 || percent > 100) {
            throw new IllegalArgumentException("Percentage should be in [0, 100]");
        }
        this.text = text;
        this.percent = percent;
    }

    public String getText() {
        return text;
    }

    public double getPercent() {
        return percent;
    }

}
