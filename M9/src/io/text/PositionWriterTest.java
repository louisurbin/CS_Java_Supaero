package io.text;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.assertj.core.api.WithAssertions;
import org.assertj.core.api.WithAssumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import geometry.Position;

@TestMethodOrder(OrderAnnotation.class)
public class PositionWriterTest implements WithAssertions, WithAssumptions {

    private Collection<Position> positions;

    @BeforeEach
    void setup() {
        positions = new ArrayList<>();
        positions.add(new Position(1, 2));
        positions.add(new Position(3, 4));
        positions.add(new Position(5, 6));
    }

    @Test
    @Order(1)
    public void writePosition() throws IOException {
        Position p = new Position(-3, -14);
        PositionWriter.write(p, "test.txt", false);
        File actualFile = new File("test.txt");
        assertThat(contentOf(actualFile))
                .contains(",")
                .isEqualToIgnoringWhitespace("-3.0,-14.0");
        actualFile.deleteOnExit();
    }

    @Test
    @Order(2)
    public void writeCanOverwrite() throws IOException {

        PositionWriter.write(new Position(-3, -14), "test.txt", false);
        PositionWriter.write(new Position(42, 51), "test.txt", false);
        File actualFile = new File("test.txt");
        assertThat(contentOf(actualFile))
                .isEqualToIgnoringWhitespace("42.0,51.0");
        actualFile.deleteOnExit();
    }

    @Test
    @Order(3)
    public void writeCanAppend() throws IOException {

        PositionWriter.write(new Position(-3, -14), "test.txt", false);
        PositionWriter.write(new Position(42, 51), "test.txt", true);
        File actualFile = new File("test.txt");
        assertThat(contentOf(actualFile))
                .isEqualToIgnoringWhitespace("-3.0,-14.0 42.0,51.0"); // also ignore newlines
        actualFile.deleteOnExit();
    }


    @Test
    @Order(10)
    public void writeList() throws IOException {
        PositionWriter.write(positions, "test.txt", false);
        File actualFile = new File("test.txt");
        assertThat(contentOf(actualFile))
                .contains(",")
                .isEqualToIgnoringWhitespace("1.0,2.0 3.0,4.0 5.0,6.0");
        actualFile.deleteOnExit();
    }

    @Test
    @Order(11)
    public void writeListCanOverwrite() throws IOException {
        PositionWriter.write(positions, "test.txt", false);
        PositionWriter.write(positions, "test.txt", false);
        File actualFile = new File("test.txt");
        assertThat(contentOf(actualFile))
                .contains(",")
                .isEqualToIgnoringWhitespace("1.0,2.0 3.0,4.0 5.0,6.0");
        actualFile.deleteOnExit();
    }

    @Test
    @Order(12)
    public void writeListCanAppend() throws IOException {
        PositionWriter.write(positions, "test.txt", false);
        PositionWriter.write(positions, "test.txt", true);
        File actualFile = new File("test.txt");
        assertThat(contentOf(actualFile))
                .contains(",")
                .isEqualToIgnoringWhitespace("1.0,2.0 3.0,4.0 5.0,6.0 1.0,2.0 3.0,4.0 5.0,6.0");
        actualFile.deleteOnExit();
    }
}
