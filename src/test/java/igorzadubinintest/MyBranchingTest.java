package igorzadubinintest;

import igorzadubinin.MyBranching;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import sbp.common.Utils;

import static org.mockito.ArgumentMatchers.anyString;

public class MyBranchingTest {
    Utils utilsMock;
    MyBranching myBranching;

    @BeforeEach
    public void init() {
        utilsMock = Mockito.mock(Utils.class);
        myBranching = new MyBranching(utilsMock);
        Mockito.when(utilsMock.utilFunc1(anyString())).thenReturn(true);
        Mockito.when(utilsMock.utilFunc2()).thenReturn(true);
    }

    @Test
    public void maxInt_Test() {
        final int i1 = 5, i2 = 10;

        //Func2 = true; Func1 = true
        Assertions.assertTrue(myBranching.maxInt(i1, i2) == 0);

        Mockito.when(utilsMock.utilFunc1(anyString())).thenReturn(false);
        //Func2 = true; Func1 = false
        Assertions.assertTrue(myBranching.maxInt(i1, i2) == 0);

        Mockito.when(utilsMock.utilFunc2()).thenReturn(false);
        //Func2 = false; Func1 = false
        Assertions.assertTrue(myBranching.maxInt(i1, i2) == (i1 >= i2 ? i1 : i2));

        Mockito.when(utilsMock.utilFunc1(anyString())).thenReturn(true);
        //Func2 = false; Func1 = true
        Assertions.assertTrue(myBranching.maxInt(i1, i2) == (i1 >= i2 ? i1 : i2));
    }

    @Test
    public void ifElseExample_Test() {
        Assertions.assertTrue(myBranching.ifElseExample());
        Mockito.when(utilsMock.utilFunc2()).thenReturn(false);
        Assertions.assertFalse(myBranching.ifElseExample());
    }

    @Test
    public void switchExampleI0_Test() {
        myBranching.switchExample(0);
        utilFuncVerify();
    }

    @Test
    public void switchExampleI1_Test() {
        myBranching.switchExample(1);
        utilFuncVerify();
    }

    @Test
    public void switchExampleI2_Test() {
        myBranching.switchExample(2);
        utilFuncVerify();
    }

    public void utilFuncVerify() {
        Mockito.verify(utilsMock).utilFunc1(anyString());
        Mockito.verify(utilsMock).utilFunc2();
    }
}
