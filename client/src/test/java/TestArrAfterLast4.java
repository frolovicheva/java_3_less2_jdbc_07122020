import home_work_6.MainForTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;


@RunWith (Parameterized.class)
public class TestArrAfterLast4 {
    private int[] actuals;
    private int[] expecteds;

    @Parameterized.Parameters
    public static List<Object[]> arrs(){
        return Arrays.asList (new Object[][]{
                {new int[]{1,2,3,4,5,6}, new int[]{5,6}},
                {new int[]{6,5,4,3,2}, new int[]{3,2}},
                {new int[]{4,4,4}, new int[]{}},
                {new int[]{16,8,4,0}, new int[]{0}},
        });
    }

    public TestArrAfterLast4(int[] actuals, int[] expected) {
        this.actuals = actuals;
        this.expecteds = expected;
    }

    @Test
    public void testArrs1(){
        Assert.assertArrayEquals (expecteds, MainForTest.newArrAfterLast4 (actuals));
    }

    @Test(expected = RuntimeException.class)
    public void testArrs2() {
        int[] arrHasNot4 = new int[]{1, 2, 3, 3, 3};
        MainForTest.newArrAfterLast4 (arrHasNot4);

    }

}
