public class RGB {
     
    final static public double MIN_RANGE = 0;
    final static public double MAX_RANGE = 1;

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
        public boolean equals(RGB other) {
            if (other == null) {
                return false;
            }
            if (other == this) {
                return true;
            }
            return this.red == other.red && this.green == other.green && this.blue == other.blue;
        }
        public boolean hasValuesInRange() {
            return red>=MIN_RANGE && red<=MAX_RANGE && green>=MIN_RANGE && green<=MAX_RANGE && blue>=MIN_RANGE && blue<=MAX_RANGE;
        }
    }
