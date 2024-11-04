package debug;

import java.io.FileReader;
import java.io.IOException;

public class DebugMain2 {
	
	public static void main(String[] args) throws IOException {
		FileReader in = new FileReader("src/example.txt");
		while(in.ready()) {
			int c = in.read();
			System.out.printf("%c", c);
		}
		in.close();
	}
	
}
