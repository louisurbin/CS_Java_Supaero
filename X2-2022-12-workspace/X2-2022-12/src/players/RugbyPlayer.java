package players;

import java.util.Objects;

public class RugbyPlayer implements Comparable<RugbyPlayer>{
   private String fullname;
   private int weight;

   public RugbyPlayer(String fullname, int weight) {
      this.fullname = fullname;
      this. weight = weight;
   }

   public String toString(){
      return fullname + "(" + weight + "kg)";
   }

   public int compareTo(RugbyPlayer other){
      if(this.weight == other.weight){
         return this.fullname.compareTo(other.fullname);
      }
      return Integer.compare(other.weight, this.weight);
   }

   public boolean equals(Object other){
      if (other == this){
         return true;
      }
      if (!(other instanceof RugbyPlayer)){
         return false;
      }  
      RugbyPlayer otherPlayer = (RugbyPlayer) other;
      return this.fullname.equals(otherPlayer.fullname) && this.weight == otherPlayer.weight;
   }

   public int hashcode(){
      return Objects.hash(fullname, weight);
   }
}
