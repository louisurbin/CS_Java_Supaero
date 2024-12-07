package steps;

public class BasicStep extends AbstractStep{
    private int duration;

    public BasicStep(String description, int duration){
        super(description);
        this.duration = duration;
    }

    public int getDuration(){
        return this.duration;
    }

    public void display(){
        System.out.printf("%s %d minute(s) \n", this.description, getDuration());
    }
}
