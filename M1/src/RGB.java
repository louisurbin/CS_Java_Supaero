public class RGB {
        
    //Attributs
        private double red;
        private double green;
        private double blue;

    //Constructeur
        public RGB(double r0, double g0, double b0) {
            this.red = r0;
            this.green = g0;
            this.blue = b0;
        }

        public void White() {
            this.red = 1;
            this.green = 1;
            this.blue = 1;
        }
    //Méthodes
        public void display() {
            System.out.println("(" + this.red + ", " + this.green + ", " + this.blue + ")");
        }
        public double greyLevel() {
            return (this.red + this.green + this.blue) / 3;
        }
        public void turnToGrey() {
            double grey = this.greyLevel();
            this.red = grey;
            this.green = grey;
            this.blue = grey;
        }
        public void set (double r, double g, double b) {
            this.red = r;
            this.blue = b;
            this.green = g;
        }
        public void set(double grey) {
            this.blue = grey;
            this.green = grey;
            this.red = grey;
        }
}
