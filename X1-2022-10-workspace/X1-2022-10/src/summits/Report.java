package summits;

public class Report {
    private String description;
    private int difficultyLevel;

    public Report(String description, int difficultyLevel){
        this.description = description;
        if (difficultyLevel < 1){
            this.difficultyLevel = 1;
        }
        else if (difficultyLevel > 4){
            this.difficultyLevel = 4;
        }
        else{
            this.difficultyLevel = difficultyLevel;
        }
    }

    public int getDifficultyLevel() {
        return this.difficultyLevel;
    }

    public String toString() {
        return this.description + " (" + this.difficultyLevel + "/4)";
    }
   
    
}
