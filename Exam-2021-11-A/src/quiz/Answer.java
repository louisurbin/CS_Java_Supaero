package quiz;

public class Answer {
    private String text;
    private boolean right;

    public Answer(String text, boolean right) {
        if (text == null || "".equals(text)) {
            throw new IllegalArgumentException("text is empty or equals to null");
        }
        this.text = text;
        this.right = right;
    }

    public boolean isRight() {
        return this.right;
    }

    public String getText() {
        return this.text;
    }
}
