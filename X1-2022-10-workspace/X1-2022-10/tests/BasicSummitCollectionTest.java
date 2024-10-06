package summits;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
public class BasicSummitCollectionTest implements WithAssertions {

   @Test
   @Order(1)
   public void testSummitCollectionCreation() {
      SummitCollection collection = new SummitCollection();
      assertThat(collection).isNotNull();
      assertThat(collection).extracting("summits").isNotNull();
   }

   @Test
   @Order(2)
   public void testAddGetOneSummit() {
      SummitCollection collection = new SummitCollection();
      Summit summit = collection.get("S1");
      assertThat(summit).isNull();
      Summit s1 = new Summit("S1", 1111);
      collection.add(s1);
      summit = collection.get("S1");
      assertThat(summit).isNotNull();
      assertThat(summit).extracting("name", "altitude").containsExactly("S1", 1111);
   }

   @Test
   @Order(3)
   public void testAddGetFourSummits() {
      SummitCollection collection = new SummitCollection();
      collection.add(new Summit("S1", 1111));
      collection.add(new Summit("S2", 2222));
      collection.add(new Summit("S3", 3333));
      collection.add(new Summit("S4", 4444));
      // random order for get
      assertThat(collection.get("S3"))
            .isNotNull()
            .extracting("name", "altitude").containsExactly("S3", 3333);
      assertThat(collection.get("S4"))
            .isNotNull()
            .extracting("name", "altitude").containsExactly("S4", 4444);
      assertThat(collection.get("S2"))
            .isNotNull()
            .extracting("name", "altitude").containsExactly("S2", 2222);
      assertThat(collection.get("S1"))
            .isNotNull()
            .extracting("name", "altitude").containsExactly("S1", 1111);
   }
}