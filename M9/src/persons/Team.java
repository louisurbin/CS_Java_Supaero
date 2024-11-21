package persons;

import java.util.ArrayList;
import java.util.List;

public class Team {

   private String name;
   private List<Person> players;
   private Person leader;

   public Team(String name) {
      this.name = name;
      this.players = new ArrayList<>();
   }

   public void setLeader(Person p) {
      this.leader = p;
      if(!this.players.contains(p)) {
         this.addPlayer(p); 
      }
   }

   public void addPlayer(Person p) {
      this.players.add(p);
   }

   @Override
   public String toString() {
      return name + " leader: " + leader.getName() + " members:" + players;
   }
}
