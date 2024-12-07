package rationals;

import java.util.Objects;

public class Rational implements Comparable<Rational> {

	private int num;
	private int denom;

	public Rational(int num, int denom) {
		if (denom == 0) {
			throw new IllegalArgumentException("Denominator is null");
		}
		else if (denom < 0) {
			throw new IllegalArgumentException("Denominator is negative");
		} else {
			int gcd = gcd(num, denom);
			this.num = num / gcd;
			this.denom = denom / gcd;
		}
	}

	public Rational(int nb) {
		this.num = nb;
		this.denom = 1;
	}

	public int getNum() {
		return num;
	}

	public int getDenom() {
		return denom;
	}

	@Override
	public String toString() {
		if (denom != 1) {
			return num + "/" + denom;
		} else {
			return num + "";
		}
	}

	/**
	 * Converts "1/3" or "4" to the corresponding rational.
	 */
	static public Rational parseRational(String s) {
		if (s.contains("/")) {
			String[] fraction = s.split("/");
			int num = Integer.parseInt(fraction[0]);
			int denom = Integer.parseInt(fraction[1]);
			return new Rational(num, denom);
		} else {
			int num = Integer.parseInt(s);
			return new Rational(num);
		}
	}

	private int gcd(int a, int b) {
		if (b==0) {
			return a;
		}
		else {
			return gcd(b, a%b);
		}
	}

	public boolean equals(Object o) {
		if(o instanceof Rational){
			Rational r = (Rational) o;
			return r.num == this.num && r.denom == this.denom;
		}
		return false;
	}

	public int compareTo(Rational r) {
		return Integer.compare(this.num * r.denom, this.denom * r.num);
	}

	public int hashCode(){
		return Objects.hash(this.num, this.denom);
	}
}
