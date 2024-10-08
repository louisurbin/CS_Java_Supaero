package controller;

import org.assertj.core.api.WithAssertions;
import org.assertj.core.api.junit.jupiter.InjectSoftAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;

import fr.supaero.grader.annotations.Grade;
import fr.supaero.grader.annotations.GradedTest;
import fr.supaero.matchers.utils.TypeInfo;
import fr.supaero.matchers.assertions.TypeSoftAssertions;

@GradedTest(gradesFile = "Ex-1.2.txt", summaryFile = "Ex-1.2.csv")
@ExtendWith(SoftAssertionsExtension.class)
@DisplayName("1.2 HouseController class")
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class HouseControllerGradingTest implements WithAssertions {

   @InjectSoftAssertions
   TypeSoftAssertions soft;
   TypeInfo info = TypeInfo.info(HouseController.class);

   @DisplayName("1.2a Attributes and constructors")
   @Grade(value = 0.5, feedback = "new HouseController() should store an empty list in attribute devices")
   @Test
   public void testControllerCreation() {
      HouseController controller = new HouseController();

      assertThat(controller).isNotNull();
      assertThat(controller).extracting("devices")
            .isNotNull()
            .asList()
            .hasSize(0);
   }

   @DisplayName("1.2b Devices management")
   @Grade(value = 1, feedback = "addThermostat(t) should add t to the devices list attribute")
   @Test
   public void testAddThermostats() {
      Thermostat t1 = new Thermostat("T1");
      Thermostat t2 = new Thermostat("T2");
      HouseController controller = new HouseController();

      controller.addThermostat(t1);
      controller.addThermostat(t2);

      assertThat(controller).extracting("devices")
            .isNotNull()
            .asList()
            .hasSize(2)
            .extracting("location")
            .containsExactly("T1", "T2");
   }

   @DisplayName("1.2c Adjust temperatures (no cutoff needed)")
   @Grade(value = 1, feedback = "adjustAll(delta) should modify all devices nominal temperatures")
   @Test
   public void testAdjustAll() {
      Thermostat t1 = new Thermostat("T1");
      t1.setNominal(18);
      Thermostat t2 = new Thermostat("T2");
      t2.setNominal(19);
      HouseController controller = new HouseController();
      controller.addThermostat(t1);
      controller.addThermostat(t2);

      // before adjusting: 18 and 19
      assertThat(controller).extracting("devices")
         .asList()
         .extracting("location", "nominal")
         .containsExactly(tuple("T1", 18.0), tuple("T2", 19.0));

      // adjust +1
      controller.adjustAll(1.0);
      assertThat(controller).extracting("devices")
         .asList()
         .extracting("location", "nominal")
         .containsExactly(tuple("T1", 19.0), tuple("T2", 20.0));
   }

   @DisplayName("1.2d Adjust temperatures (high and low cutoff)")
   @Grade(value = 0.5, feedback = "adjustAll(delta) should modify all devices nominal temperatures, cutting off if necessary")
   @Test
   public void testAdjustAllWithSaturation() {
      Thermostat t1 = new Thermostat("T1");
      t1.setNominal(18);
      Thermostat t2 = new Thermostat("T2");
      t2.setNominal(22);
      HouseController controller = new HouseController();
      controller.addThermostat(t1);
      controller.addThermostat(t2);

      // one upper cut-off
      controller.adjustAll(5.0);
      assertThat(controller).extracting("devices")
         .asList()
         .extracting("location", "nominal")
         .containsExactly(tuple("T1", 23.0), tuple("T2", 25.0));

      // two lower cut-offs
      controller.adjustAll(-10);
      assertThat(controller).extracting("devices")
         .asList()
         .extracting("location", "nominal")
         .containsExactly(tuple("T1", 17.0), tuple("T2", 17.0));
   }

   @DisplayName("1.2e Public and private access")
   @Grade(value = 0.5, feedback = "Non-constant attributes should be private, constructors and methods should be public")
   @Test
   public void accessControl() {
      soft.assertThat(info)
            .hasFieldCountGreaterThanOrEqualTo(1)
            .hasOnlyPrivateAttributes()
            .hasConstructorCountGreaterThanOrEqualTo(1)
            .hasOnlyPublicConstructors()
            .hasMethodCountGreaterThanOrEqualTo(1)
            .hasOnlyPublicMethods();
   }

   @DisplayName("1.2f Textual representation")
   @Test
   @Grade(value = 0.5, feedback = "toString() should display all stored devices")
   public void textualRepresentation() {
      Thermostat t1 = new Thermostat("T1");
      t1.setNominal(18);
      Thermostat t2 = new Thermostat("T2");
      HouseController controller = new HouseController();
      controller.addThermostat(t1);
      controller.addThermostat(t2);

      String text = controller.toString();
      soft.assertThat(text).
         contains("T1", "T2", "18", "21");
   }
}
