package plots;

import javax.swing.JFrame;
import ptolemy.plot.Plot;

public class TrigonometryPlotterMain {
    public static void main(String[] args) {
        Plot plot = new Plot();
        plot.setMarksStyle("dots");

        for (int i=0; i<360; i+=20) {
            plot.addPoint(0,i,Math.sin(i*Math.PI/180),false);
            plot.addPoint(1,i,Math.cos(i*Math.PI/180),false);
        }
        JFrame frame = new JFrame("My First Plotter");
        frame.add(plot);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
} 

