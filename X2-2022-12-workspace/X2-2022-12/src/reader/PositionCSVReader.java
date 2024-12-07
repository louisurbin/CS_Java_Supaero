package reader;

public class PositionCSVReader extends AbstractLineReader<Position>{
    public PositionCSVReader(){
        super("position");
    }

    protected Position getElementFromLine(String line) {
        String[] tokens = line.split(",");
        if(tokens.length !=2){
            throw new IllegalArgumentException("erreur de format");
        }
        double x = Double.parseDouble(tokens[0].trim());
		double y = Double.parseDouble(tokens[1].trim());
        return new Position(x, y);
    }
}