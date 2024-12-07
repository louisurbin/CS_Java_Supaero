package steps;

import java.util.ArrayList;

public class Repeat extends AbstractStep {
    private int count;
    private ArrayList<AbstractStep> steps;

    public Repeat(String description, int count){
        super(description);
        this.count = count;
        this.steps = new ArrayList<>();
    }

    public void addStep(AbstractStep step){
        steps.add(step);
    }

    public int getDuration(){
        int d = 0;
        for (AbstractStep step : steps){
            d += step.getDuration();
        }
        d *= count;
        return d;
    }

    public void display(){
        System.out.printf("%s %d minute(s)\n", this.description, this.getDuration());
        System.out.printf("Répéter %d fois :\n", this.count);
        
        for (AbstractStep step : steps){
            step.display();
        }
        System.out.println(description + " " + getDuration() + " minute(s) : fin");
    }
    
}
