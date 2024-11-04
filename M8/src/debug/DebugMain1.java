package debug;

public class DebugMain1 {

	public static void main(String[] args) {
		Position[] positions = new Position[3];
		positions[0] = new Position(3, 4);
		positions[1] = new Position(5, 6);
		positions[2] = new Position(7, 8);
		for(int i = 0; i < positions.length; i++) {
			if(positions[i] != null) {
				positions[i].translate(i, i);
				System.out.println(positions[i]);
			}
		}
	}

}
