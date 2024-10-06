package summits;

public class SummitsMain {
   public static void main(String[] args) {
      // Report
   
      Report report = new Report("Fantastique mais difficile", 400);
      System.out.println(report); // should contain 4/4


      // Summit
       
      Summit vignemale = new Summit("Pique Longue", 3298);
      System.out.println(vignemale); // should print Pique Longue and no report
      vignemale.addReport(new Report("Fastoche sauf la fin", 2));
      vignemale.addReport(new Report("Long et difficile", 4));
      vignemale.addReport(new Report("Fastoche après la Pène Sarrière", 1));
      System.out.println(vignemale); // should print Pique Longue and 3 reports
      

      // SummitCollection
      
      SummitCollection collection = new SummitCollection();
      Summit s = collection.get("Pique Longue");
      System.out.println(s); // should print null
      collection.add(vignemale);
      s = collection.get("Pique Longue");
      System.out.println(s); // should print Pique Longue as before
      
   }
}
