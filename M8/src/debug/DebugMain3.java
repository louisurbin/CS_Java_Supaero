package debug;

public class DebugMain3 {

	public static void main(String[] args) {
		Position[] positions = new Position[5];
		for (int i = 0; i < 5; i++) {
			positions[i] = new Position(i, i);
			System.out.println(positions[i]);
		}
	}

}
