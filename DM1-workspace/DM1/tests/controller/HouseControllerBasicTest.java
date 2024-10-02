package controller;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class HouseControllerBasicTest implements WithAssertions {

   @Test
   @Order(1)
   public void testControllerCreation() {
      HouseController controller = new HouseController();

      assertThat(controller).isNotNull();
      assertThat(controller).extracting("devices")
            .isNotNull()
            .asList()
            .hasSize(0);
   }

   @Test
   @Order(2)
   public void testAddThermostat() {
      Thermostat t1 = new Thermostat("T1");
      Thermostat t2 = new Thermostat("T2");
      HouseController controller = new HouseController();

      controller.addThermostat(t1);
      controller.addThermostat(t2);

      assertThat(controller).extracting("devices")
            .isNotNull()
            .asList()
            .hasSize(2)
            .contains(t1, t2);
   }

   @Test
   @Order(3)
   public void testAdjustAll() {
      Thermostat t1 = new Thermostat("T1");
      Thermostat t2 = new Thermostat("T2");
      t1.setNominal(18);
      HouseController controller = new HouseController();
      controller.addThermostat(t1);
      controller.addThermostat(t2);

      // before adjusting: 18 and standard 21
      assertThat(controller).extracting("devices")
         .asList()
         .extracting("location", "nominal")
         .containsExactly(tuple("T1", 18.0), tuple("T2", 21.0));

      controller.adjustAll(1);
      assertThat(controller).extracting("devices")
         .asList()
         .extracting("location", "nominal")
         .containsExactly(tuple("T1", 19.0), tuple("T2", 22.0));
   }

   @Test
   @Order(4)
   public void testAdjustAllWithSaturation() {
      Thermostat t1 = new Thermostat("T1");
      Thermostat t2 = new Thermostat("T2");
      t1.setNominal(18);
      HouseController controller = new HouseController();
      controller.addThermostat(t1);
      controller.addThermostat(t2);

      controller.adjustAll(6);
      assertThat(controller).extracting("devices")
         .asList()
         .extracting("location", "nominal")
         .containsExactly(tuple("T1", 24.0), tuple("T2", 25.0));

      controller.adjustAll(-10);
      assertThat(controller).extracting("devices")
         .asList()
         .extracting("location", "nominal")
         .containsExactly(tuple("T1", 17.0), tuple("T2", 17.0));
   }
}
