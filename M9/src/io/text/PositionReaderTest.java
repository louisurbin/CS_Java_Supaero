package io.text;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.assertj.core.api.WithAssertions;
import org.assertj.core.api.WithAssumptions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import geometry.Position;

@TestMethodOrder(OrderAnnotation.class)
public class PositionReaderTest implements WithAssertions, WithAssumptions {

    @Test
    @Order(1)
    public void readOneLineFile() throws IOException {
        writeFile("position_test.txt", "1.0,2.0\n");
        List<Position> positions = PositionReader.read("position_test.txt");
        assertThat(positions).isNotNull();
        assertThat(positions).hasSize(1);
        assertThat(positions.get(0)).extracting("x", "y").containsExactly(1.0, 2.0);
    }

    @Test
    @Order(2)
    public void readOneLineFileNoNewline() throws IOException {
        writeFile("position_test.txt", "1.0,2.0");
        List<Position> positions = PositionReader.read("position_test.txt");
        assertThat(positions).isNotNull();
        assertThat(positions).hasSize(1);
        assertThat(positions.get(0)).extracting("x", "y").containsExactly(1.0, 2.0);
    }

    @Test
    @Order(3)
    public void readMultiLineFile() throws IOException {
        writeFile("position_test.txt", "1.0,2.0\n3.0,4.0\n5.0,6.0");
        List<Position> positions = PositionReader.read("position_test.txt");
        assertThat(positions).isNotNull();
        assertThat(positions).hasSize(3);
        assertThat(positions.get(0)).extracting("x", "y").containsExactly(1.0, 2.0);
        assertThat(positions.get(1)).extracting("x", "y").containsExactly(3.0, 4.0);
        assertThat(positions.get(2)).extracting("x", "y").containsExactly(5.0, 6.0);
    }

    // uncomment out the following methods to test your reader robustness

    // @Test
    // @Order(10)
    // public void readEmptyFile() throws IOException {
    //     writeFile("position_test.txt", "");
    //     List<Position> positions = PositionReader.read("position_test.txt");
    //     assertThat(positions).isNotNull();
    //     assertThat(positions).isEmpty();
    // }

    // @Test
    // @Order(11)
    // public void readCorruptedFile() throws IOException {
    //     writeFile("position_test.txt", "1.0,");
    //     List<Position> positions = PositionReader.read("position_test.txt");
    //     assertThat(positions).isNotNull();
    //     assertThat(positions).isEmpty();
    // }

    // @Test
    // @Order(12)
    // public void readReallyCorruptedFile() throws IOException {
    //     writeFile("position_test.txt", "one,two");
    //     List<Position> positions = PositionReader.read("position_test.txt");
    //     assertThat(positions).isNotNull();
    //     assertThat(positions).isEmpty();
    // }

    // helper method

    private File writeFile(String fileName, String fileContent) throws IOException {
        File file = new File(fileName);
        PrintWriter out = new PrintWriter(new FileWriter(fileName, false));
        out.write(fileContent);
        out.close();
        file.deleteOnExit();
        return file;
    }
}
