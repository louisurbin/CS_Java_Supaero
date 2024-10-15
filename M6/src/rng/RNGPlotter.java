package rng;

import java.awt.Dimension;
import javax.swing.JFrame;
import ptolemy.plot.Plot;

public class RNGPlotter {

	private Plot plot;
	private JFrame frame;

	/**
	 * Create an empty plotting window of size width x height, e.g. 800x600 (4/3) or
	 * 800x450 (16/9).
	 * 
	 * @param width  Width in pixels
	 * @param height Height in pixels
	 * @see #show(int, RNG, int) to add a sample set to this window
	 */
	public RNGPlotter(int width, int height) {
		// initialize PtPlot's plotter widget with the specified size
		plot = new Plot();
		plot.setMarksStyle("points");
		plot.setSize(new Dimension(width, height));

		// put it in a main window
		frame = new JFrame("Plotter");
		frame.add(plot);
		frame.pack();
		frame.setVisible(true);

		// exits the Java program when you close the main window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Creates a new sample serie and adds it to the plotting window, with a
	 * distinctive index.
	 * 
	 * @param serieIndex The series's index
	 * @param rng        The random number generator used to get samples
	 * @param amount     Sample set size
	 */
	public void show(int serieIndex, AbstractRNG rng, int amount) {
		// remove all points at the same index
		plot.clear(serieIndex);

		// add a legend for the serie
		plot.addLegend(serieIndex, rng.toString());

		// generate samples and add them to the serie
		for (int i = 0; i < amount; i++) {
			double x = i;
			double y = rng.genSample();
			plot.addPoint(serieIndex, x, y, false);

			// not really useful but somewhat animates the whole thing
			plot.repaint();
		}
	}

	/**
	 * Plots 2 random series: Gaussian and Uniform.
	 * 
	 * @param args Not used
	 */
	public static void main(String[] args) {
		RNGPlotter plotter = new RNGPlotter(800, 450);
		int nb = 5000;
		plotter.show(0, new UniformRNG(1, 3), nb);
		plotter.show(1, new GaussianRNG(0, 0.1), nb);
	}

}
