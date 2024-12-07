package rationals;

import java.util.TreeSet;

public class EgyptianFraction {
    private TreeSet<Rational> fractions;

    public EgyptianFraction() {
        fractions = new TreeSet<>();
    }

    public void addUnitFraction(int denom) {
        fractions.add(new Rational(1, denom));
    }

    public String toString() {
        String str = fractions.reversed().toString();
        str = str.replace("[", "");
        str = str.replace("]", "");
        str = str.replace(",", " +");
        return str;
    }
}
