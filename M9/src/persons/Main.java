package persons;

import java.io.IOException;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        try {
            TreeMap<String, Team> teams = TeamReader.read("teams.txt", PersonReader.read("persons.txt"));
            for (Team team : teams.values()) {
                System.out.println(team);
            }
        } catch (IOException e) {
            System.err.println("Error reading teams: " + e.getMessage());
        }
    }
}
