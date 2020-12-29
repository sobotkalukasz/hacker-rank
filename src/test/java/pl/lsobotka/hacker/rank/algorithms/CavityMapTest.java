package pl.lsobotka.hacker.rank.algorithms;

import org.junit.jupiter.api.Test;
import pl.lsobotka.hacker.rank.BaseTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CavityMapTest extends BaseTest {

    @Test
    public void cavityMapFile() throws Exception {

        String inputName = "CavityMap_input";
        String outputName = "CavityMap_output";

        List<String> input = getFileInput(inputName);
        List<String> expected = getFileInput(outputName);

        String[] output = CavityMap.cavityMap(input.toArray(new String[0]));

        assertEquals(expected, Arrays.asList(output));
    }
}
