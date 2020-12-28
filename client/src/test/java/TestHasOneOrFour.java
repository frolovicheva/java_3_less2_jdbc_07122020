import home_work_6.MainForTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class TestHasOneOrFour {
    private int[] actualArr;
    private boolean isTrue;

    @Parameterized.Parameters
    public static List<Object[]> arrs(){
        return Arrays.asList (new Object[][]{
                {new int[]{1,1,1,4,4,4}, true},
                {new int[]{1,4,3,3,3}, false},
                {new int[]{4,4,4}, false},
                {new int[]{1,1,1,1}, false},
        });
    }

    public TestHasOneOrFour(int[] actualArr, boolean isTrue) {
        this.actualArr = actualArr;
        this.isTrue = isTrue;
    }

    @Test
    public void testArrsWithOneAndFour(){
        Assert.assertEquals (isTrue, MainForTest.hasOneOrFour (actualArr));
    }

}
