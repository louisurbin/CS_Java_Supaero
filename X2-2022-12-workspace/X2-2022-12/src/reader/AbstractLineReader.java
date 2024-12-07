package reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractLineReader<T> {
    private String dataLabel;
    
    protected AbstractLineReader(String dataLabel){
        this.dataLabel = dataLabel;
    }

    public List<T> read(String fileName){
        List<T> list = new ArrayList<>();
        try{
			FileReader in = new FileReader(fileName);
			BufferedReader bin = new BufferedReader(in);
			String line;
			int lineNumber = 0;
			while((line = bin.readLine()) != null) {
				lineNumber++;
                try {
                    list.add(getElementFromLine(line));
                }
				catch (NumberFormatException e) {
					System.err.println(fileName + ": cannot get " + dataLabel + " from line " + lineNumber);
				}
			}
		} 
		catch (IOException e) {
			System.err.println("Error while reading file: " + e.getMessage());
		}
        return list;
    }

    protected abstract T getElementFromLine(String line);
}
