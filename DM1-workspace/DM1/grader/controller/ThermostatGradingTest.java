package controller;

import java.io.File;
import java.util.LinkedHashSet;
import java.util.Set;

import org.assertj.core.api.Condition;
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
import fr.supaero.matchers.utils.FieldInfo;
import fr.supaero.matchers.utils.TypeInfo;
import fr.supaero.matchers.assertions.TypeSoftAssertions;

@GradedTest(gradesFile = "Ex-1.1.txt", summaryFile = "Ex-1.1.csv")
@ExtendWith(SoftAssertionsExtension.class)
@DisplayName("1.1 Thermostat class")
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class ThermostatGradingTest implements WithAssertions {

   @InjectSoftAssertions
   TypeSoftAssertions soft;
   TypeInfo info = TypeInfo.info(Thermostat.class);

   @DisplayName("1.1a Attributes, constructor and toString()")
   @Grade(value = 1.0, feedback = "new Thermostat(loc) should store loc and 21 as nominal temp; toString() should display attributes values")
   @Test
   public void constructionBasics() {
      String location = "A location";
      Thermostat t = new Thermostat(location);
      soft.assertThat(t).isNotNull();
      soft.assertThat(t).extracting("location").isEqualTo(location);
      soft.assertThat(t).extracting("nominal").isEqualTo(21.0);
      soft.assertThat(t.toString()).contains(location, "21");
   }

   @DisplayName("1.1b Keep nominal temperatures")
   @Grade(value = 1.0, feedback = "nominal temperature in 17..25 should be stored without modification")
   @Test
   public void setNominalForNormalValues() {
      Thermostat t = new Thermostat("Loc1");
      double[] temperatures = { 17.0, 18, 20, 24, 25 };
      for (double temperature : temperatures) {
         t.setNominal(temperature);
         soft.assertThat(t).extracting("nominal").isEqualTo(temperature);
         soft.assertThat(t.getNominal()).isEqualTo(temperature);
      }
   }

   @DisplayName("1.1c Cut off temperatures < 17")
   @Test
   @Grade(value = 1.0, feedback = "nominal temperature < 17 should be stored as 17")
   public void setNominalForLowValues() {
      Thermostat t = new Thermostat("Loc1");
      double[] temperatures = { 17.0 - Double.MIN_NORMAL, Double.MIN_VALUE };
      for (double temperature : temperatures) {
         t.setNominal(temperature);
         soft.assertThat(t).extracting("nominal").isEqualTo(17.0);
         soft.assertThat(t.getNominal()).isEqualTo(17.0);
      }
   }

   @DisplayName("1.1d Cut off temperatures > 25")
   @Test
   @Grade(value = 1.0, feedback = "nominal temperature > 25 should be stored as 25")
   public void setNominalForHighValues() {
      Thermostat t = new Thermostat("Loc1");
      double[] temperatures = { 25.0 + Double.MIN_NORMAL, Double.MAX_VALUE };
      for (double temperature : temperatures) {
         t.setNominal(temperature);
         soft.assertThat(t).extracting("nominal").isEqualTo(25.0);
         soft.assertThat(t.getNominal()).isEqualTo(25.0);
      }
   }

   @DisplayName("1.1e Public and private access")
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

   @DisplayName("1.1f Constant definition")
   @Grade(value = 0.5, feedback = "At least one attribute should be \"final static\"")
   @Test
   public void someConstantDeclared() throws Exception {
      soft.assertThat(info).has(anyFieldMatching("final static .*"));
   }

   @DisplayName("1.1g Constant usage")
   @Grade(value = 0.5, feedback = "An attribute defined as \"final static\" should be also used inside methods")
   @Test
   public void someConstantUsed() throws Exception {
      Set<FieldInfo> fields = findMatchingFields(info, "final static .*");
      assertThat(fields).areAtLeastOne(usedIn("src/controller/Thermostat.java"));
   }

   @DisplayName("1.1h Complete UML constants definition and usage")
   @Grade(value = 0.5, feedback = "All constants from the UML diagram should be declared and used")
   @Test
   @SuppressWarnings("unchecked")
   public void expectedConstantDeclarations() throws Exception {
      soft.assertThat(info).has(
            allOf(
                  fieldMatching("final static public (double|Double) STANDARD_TEMPERATURE"),
                  fieldMatching("final static public (double|Double) MIN_TEMPERATURE"),
                  fieldMatching("final static public (double|Double) MAX_TEMPERATURE"),
                  constantWithValue("STANDARD_TEMPERATURE", 21.0),
                  constantWithValue("MIN_TEMPERATURE", 17.0),
                  constantWithValue("MAX_TEMPERATURE", 25.0),
                  fieldUsedIn("STANDARD_TEMPERATURE", "src/controller/Thermostat.java"),
                  fieldUsedIn("MIN_TEMPERATURE", "src/controller/Thermostat.java"),
                  fieldUsedIn("MAX_TEMPERATURE", "src/controller/Thermostat.java")));
   }

   // Class attribute conditions

   private Condition<TypeInfo> fieldMatching(String declarationRegex) {
      String[] tokens = declarationRegex.split("\\s+");
      String name = tokens[tokens.length - 1];
      return new Condition<>(typeInfo -> typeInfo.getDeclaredFieldsNames().contains(name) &&
            typeInfo.getField(name).declaration.matches(declarationRegex),
            "attribute matching " + declarationRegex);
   }

   private Condition<TypeInfo> anyFieldMatching(String declarationRegex) {
      return new Condition<>(typeInfo -> findMatchingFields(typeInfo, declarationRegex).size() > 0,
            "any attribute matching " + declarationRegex);
   }

   private Condition<TypeInfo> constantWithValue(String name, double value) {
      return new Condition<>(typeInfo -> typeInfo.getDeclaredFieldsNames().contains(name) &&
            typeInfo.getField(name).declaration.matches("final static .*") &&
            constantValueIs(typeInfo.getField(name), value),
            name + " constant value = " + value);
   }

   private Condition<TypeInfo> fieldUsedIn(String name, String filename) {
      return new Condition<>(typeInfo -> typeInfo.getDeclaredFieldsNames().contains(name) &&
            contentOf(new File(filename)).split(name).length >= 3,
            name + " used several times in " + filename);
   }

   private Condition<FieldInfo> usedIn(String filename) {
      return new Condition<>(fieldInfo -> contentOf(new File(filename)).split(fieldInfo.name).length >= 3,
            "used several times in " + filename);
   }

   // other helpers

   private boolean constantValueIs(FieldInfo fieldInfo, double value) {
      try {
         fieldInfo.field.setAccessible(true); // in case it is private
         if (fieldInfo.field.getType().equals(Double.TYPE)) {
            return fieldInfo.field.getDouble(null) == value;
         } else if (fieldInfo.field.getType().equals(Double.class)) {
            return Double.valueOf(value).equals(fieldInfo.field.get(null));
         } else {
            return false;
         }
      } catch (Exception e) {
         e.printStackTrace();
         return false;
      }
   }

   private Set<FieldInfo> findMatchingFields(TypeInfo info, String regex) {
      Set<FieldInfo> result = new LinkedHashSet<>();
      for (FieldInfo fieldInfo : info.getDeclaredFields().values()) {
         if (fieldInfo.declaration.matches(regex)) {
            result.add(fieldInfo);
         }
      }
      return result;
   }

}
