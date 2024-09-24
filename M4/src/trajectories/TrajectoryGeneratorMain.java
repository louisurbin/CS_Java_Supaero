package trajectories;

import geometry.Polyline;
import javax.swing.JFrame;
import ptolemy.plot.Plot;

public class TrajectoryGeneratorMain {
    public static void main (String[] args){
        
        int N = Integer.parseInt(args[0]);
        TrajectoryGenerator trajgene = new TrajectoryGenerator(N);
        
        if(args.length == 2){
        
            double step = Double.parseDouble(args[1]);
            
            Polyline traj = trajgene.generateBrownian(step);
            
            //System.out.println(traj.toString());

            Plot plot = new Plot();
            for (int i=0; i<N; i++){
                plot.addPoint(0,traj.getX(i),traj.getY(i),true);
            }
            JFrame frame = new JFrame("Trajectory");
            frame.add(plot);
            frame.pack();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        else if(args.length == 5 ){

            double xmin = Double.parseDouble(args[1]);
            double xmax = Double.parseDouble(args[2]);
            double ymin = Double.parseDouble(args[3]);
            double ymax = Double.parseDouble(args[4]);

            Polyline traj = trajgene.generateRandom(xmin, xmax, ymin, ymax);
            
            //System.out.println(traj.toString());

            Plot plot = new Plot();
            for (int i=0; i<N; i++){
                plot.addPoint(0,traj.getX(i),traj.getY(i),true);
            }
            JFrame frame = new JFrame("Trajectory");
            frame.add(plot);
            frame.pack();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        }
        else {
            System.out.println("Invalid number of arguments");
        }
    }
}

