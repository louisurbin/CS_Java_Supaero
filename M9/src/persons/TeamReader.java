package persons;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class TeamReader {
        
        /**
        * Reads teams from a text file. The file must be in the CSV format:
        * <ul>
        * <li> One team per line
        * <li> Each line must be in the format: 
        * <pre>
        * teamName,leaderName,player1Name,player2Name,...
        * </pre>
        * </ul>
        * 
        * Here is an example file of CSV file content:
        * 
        * <pre>
        * Team1,John Doe,John Doe,Jane Doe
        * Team2,Jane Doe,Jane Doe,John Doe
        * </pre>
    	 * 
        * @param filename Path of the file to read, e.g. "data/teams.txt"
        * @return A TreeMap of teams in the text file
        * @throws IOException when the file cannot be read or has a bad format.
        */
        static public TreeMap<String, Team> read(String filename, TreeMap<String, Person> persons) throws IOException {
            FileReader in = new FileReader(filename);
            BufferedReader bin = new BufferedReader(in);
    
            TreeMap<String, Team> teams = new TreeMap<>();
            while(bin.ready()) {
                String line = bin.readLine();
                String[] tokens = line.split(",");
                String teamName = tokens[0].trim();
                String leaderName = tokens[1].trim();
                Team team = new Team(teamName);
                Person leader = persons.get(leaderName);
                if (leader == null) {
                    throw new IOException("Leader not found in persons: " + leaderName);
                }
                team.setLeader(leader);
                for(int i = 2; i < tokens.length; i++) {
                    String playerName = tokens[i].trim();
                    Person player = persons.get(playerName);
                    if (player == null) {
                        throw new IOException("Player not found in persons: " + playerName);
                    }
                    team.addPlayer(player);
                }
                teams.put(teamName, team);
            }
            bin.close();
            return teams;
        }
}
