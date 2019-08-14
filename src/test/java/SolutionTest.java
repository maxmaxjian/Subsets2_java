import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SolutionTest {
    private int[] input;
    private List<List<Integer>> expected;
    private Solution soln = new Solution1();

    public SolutionTest(int[] input, List<List<Integer>> output) {
        this.input = input;
        this.expected = output;
    }

    @Parameterized.Parameters
    public static Collection parameters() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,2,2}, Arrays.asList(
                        Collections.EMPTY_LIST, Arrays.asList(1), Arrays.asList(2),
                        Arrays.asList(1,2), Arrays.asList(2,2), Arrays.asList(1,2,2)
                )},
                {new int[]{4,4,4,1,4}, Arrays.asList(
                        Collections.EMPTY_LIST, Arrays.asList(1), Arrays.asList(4),
                )}
        });
    }

    @Test
    public void testFunction() {
        assertEquals(expected, soln.subsetsWithDup(input));
    }
}