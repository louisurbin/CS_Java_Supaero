package trajectories;

import geometry.Polyline;
import geometry.Position;
 
public class TrajectoryGenerator {
    
    private final int N;  
    
    //constructor

    public TrajectoryGenerator() {
        this.N = 0;
    } 

    public TrajectoryGenerator(int N0) {
        this.N = N0;
    }

    //methods

    public  Polyline generateRandom(double xmin, double xmax, double ymin, double ymax){
        Polyline traj = new Polyline();
        
        for (int i = 0; i<(this.N); i++){
            double x =  Math.random()*(xmax-xmin) + xmin;
            double y =  Math.random()*(ymax-ymin) + ymin;
            traj.addVertex(new Position(x,y));
        }
        return traj;
    }

    public Polyline generateBrownian(double step){
        Polyline trajbrow = new Polyline();
        double x = 0;
        double y = 0;
        double theta ;
        for (int i = 0; i<(this.N); i++){
            theta = Math.random();
            x += step * Math.sin(theta*2*Math.PI);
            y += step * Math.cos(theta*2*Math.PI);
            trajbrow.addVertex(new Position(x,y));
        }
        return trajbrow;
    }

    public Polyline generate(Mouvement mouvement, int N0) {
        TrajectoryGenerator trajgene = new TrajectoryGenerator(N0);
        
        switch (mouvement) {
            case Random: 
                return trajgene.generateRandom(0.0, 1.0, 0.0, 1.0);
            case Brownian:
                return trajgene.generateBrownian(1.0);
            default:
                throw new IllegalArgumentException("Unknown movement type: " + mouvement);
        }
    }
}
