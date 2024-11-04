package debug;

public class DebugMain4 {

	public static void main(String[] args) {
		Position[] positions = new Position[5];
		for (int i = 0; i < positions.length; i++) {
			if(i % 2 == 0) {
				positions[i] = new Position(i, 0);
			} else {
				positions[1] = new Position(0, i);
			}
			System.out.println(positions[i]);
		}
	}

}
