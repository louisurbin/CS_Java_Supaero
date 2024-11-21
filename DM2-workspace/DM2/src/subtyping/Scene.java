package subtyping;

import java.util.ArrayList;

public class Scene {
    private ArrayList<AbstractShape> shapes;

    public Scene() {
        ArrayList<AbstractShape> shapes = new ArrayList<>();
    }

    public void addShape(AbstractShape shape) {
        shapes.add(shape);
    }

    public double sumOfVolumes() {
        double sum = 0;
        for(AbstractShape shape : shapes) {
            sum += shape.volume();
        }
        return sum;
    }
}
