package persons;

public class ClubMain {
   public static void main(String[] args) {
      Club minions = new Club("Minions & Co");
      minions.enroll(new Student("Kevin", 21, "promo24"));
      minions.enroll(new Student("Stuart", 21, "promo24"));
      minions.enroll(new Student("Bob", 20, "promo24"));
      minions.enroll(new Teacher("Nefario", 99, "Evil"));
      minions.display();
   }
}
