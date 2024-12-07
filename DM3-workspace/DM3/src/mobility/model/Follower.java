package mobility.model;

public class Follower extends Mobile {
    private int M;
    private Mobile leader;
    private double theta = 0;
    private int stepCount = 0;

    public Follower(int x, int y, Mobile leader, int M) {
        super(x, y, leader.getSpeed());
        this.leader = leader;
        this.M = M;
        this.theta = 0;
        this.stepCount = 0;
    }

    public void move(double timeStep) {
        if (stepCount % M == 0) {
            double dx = leader.getX() - x;
            double dy = leader.getY() - y;
            double alpha = Math.atan2(dy, dx);
            this.theta = alpha + Math.PI / 12 * rand.nextGaussian();
        }
        stepCount++;
        double dx = speed * timeStep * Math.cos(this.theta);
        double dy = speed * timeStep * Math.sin(this.theta);
        this.x += dx;
        this.y += dy;
    }

    public String toString() {
        return "F (" + x + ", " + y + ")" + "->" + leader;
    }
}
