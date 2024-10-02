package controller;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@TestMethodOrder(OrderAnnotation.class)
public class ThermostatBasicTest implements WithAssertions {

   @ParameterizedTest
   @CsvSource({
      "Loc 1",
      "Loc 2",
      "Loc 3",
   })
   @Order(1)
   public void testThermostatCreation(String location) {
      Thermostat thermostat = new Thermostat(location);
      assertThat(thermostat).isNotNull();
      assertThat(thermostat).extracting("location").isEqualTo(location);
      assertThat(thermostat).extracting("nominal").isEqualTo(21.0);
      assertThat(thermostat.getNominal()).isEqualTo(21);
      assertThat(thermostat.toString()).containsSubsequence(location, "21");
   }

   @ParameterizedTest
   @CsvSource({
      // input, expected
      "17.0, 17.0",
      "20.5, 20.5",
      "21.0, 21.0",
      // cut off high values
      "25.1, 25.0",
      "50.0, 25.0",
      // cut off low values
      "16.9, 17.0",
      "-50, 17.0",
   })
   @Order(2)
   public void testSetNominal(double input, double expected) {
      Thermostat thermostat = new Thermostat("Here");
      thermostat.setNominal(input);
      assertThat(thermostat).isNotNull();
      assertThat(thermostat).extracting("nominal").isEqualTo(expected);
      assertThat(thermostat.getNominal()).isEqualTo(expected);
      assertThat(thermostat.toString()).containsSubsequence(expected + "");
   }

}