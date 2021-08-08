package sbp.semenov;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import sbp.branching.MyBranching;
import sbp.common.Utils;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MyBranchingTest {

    MyBranching myBranching;
    Utils utilsMock;

    @BeforeAll
    void init() {
        utilsMock = Mockito.mock(Utils.class);
        myBranching = new MyBranching(utilsMock);
    }

    @AfterEach
    void resetMock(){
        Mockito.reset(utilsMock);
    }

    @Test
    void testMaxInt1() {
        final int inputParameter1 = 8;
        final int inputParameter2 = 88;
        final boolean[] booleanCases = {true, false};

        final int[] expected = {0, 88};
        int[] actual = new int[expected.length];

        for (int i = 0; i < expected.length; i++) {
            boolean b = booleanCases[i];
            Mockito.when(utilsMock.utilFunc2()).thenReturn(b);
            actual[i] = myBranching.maxInt(inputParameter1, inputParameter2);
        }

        assertArrayEquals(expected, actual);
    }


    @Test
    void testIfElseExample() {
        boolean[] expected = {true, false};
        boolean[] actual = new boolean[expected.length];

        for (int i = 0; i < expected.length; i++) {
            boolean b = expected[i];
            Mockito.when(utilsMock.utilFunc2()).thenReturn(b);
            actual[i] = myBranching.ifElseExample();
        }

        assertArrayEquals(expected, actual);
    }

    @Test
    void testSwitchExample0() {
        int input = 0;
        Mockito.when(utilsMock.utilFunc2()).thenReturn(true);

        myBranching.switchExample(input);
        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc1("abc2");
        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc2();
    }

    @Test
    void testSwitchExample1() {
        int input = 1;

        myBranching.switchExample(input);
        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc1("abc");
        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc2();
    }

    @Test
    void testSwitchExample2() {
        int input = 2;

        myBranching.switchExample(input);
        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc2();
    }

}
