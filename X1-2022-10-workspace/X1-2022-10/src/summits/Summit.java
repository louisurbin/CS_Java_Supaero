package summits;

import java.util.ArrayList;

public class Summit {
    private String name;
    private int altitude;
    private ArrayList<Report> reports;

    public Summit(String name, int altitude){
        this.altitude = altitude;
        this.name = name;
        this.reports = new ArrayList<>();
    }

    public void addReport(Report report){
        this.reports.add(report);
    }

    public String getName(){
        return this.name;
    }

    public double meanDifficultyLevel(){
        if (this.reports.isEmpty()){
            return Double.NaN;
        }
        else{
            double moy = 0;
            for(Report report : reports){
                moy += report.getDifficultyLevel();
            }
            moy = moy/reports.size();
            return moy;
        }
    }

    public String toString() {
        if(!this.reports.isEmpty()){
            return this.name + ", " + this.altitude + ", " +  this.reports.size() + ", " + this.meanDifficultyLevel();
        }
        else {
            return this.name + ", " + this.altitude + ", aucun rapport d'ascension";
        }
    }


}
