package DamirValiullin.branching;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import DamirValiullin.branching.MyBranching;
import DamirValiullin.common.Utils;
import sbp.branching.MyCycles;

import static org.mockito.ArgumentMatchers.anyString;

public class MyBranchingTest
{
    Utils utilsMock;
    MyBranching myBranching;

    @BeforeEach
    public  void init(){
        utilsMock = Mockito.mock(Utils.class);
        myBranching = new MyBranching(utilsMock);
    }

    @Test
    public void maxInt_test_0_0()
    {
        int i1 = 3, i2 = 7;
        Mockito.when(utilsMock.utilFunc1("Hello")).thenReturn(false);
        Mockito.when(utilsMock.utilFunc2()).thenReturn(false);

        Assertions.assertEquals(myBranching.maxInt(i1, i2), i2);
    }

    @Test
    public void maxInt_test_0_1()
    {
        int i1 = 3, i2 = 7;
        Mockito.when(utilsMock.utilFunc1("Hello")).thenReturn(false);
        Mockito.when(utilsMock.utilFunc2()).thenReturn(true);

        Assertions.assertEquals(myBranching.maxInt(i1, i2), 0);
    }

    @Test
    public void maxInt_test_1_0()
    {
        int i1 = 3, i2 = 7;
        Mockito.when(utilsMock.utilFunc1("Hello")).thenReturn(true);
        Mockito.when(utilsMock.utilFunc2()).thenReturn(false);

        Assertions.assertEquals(myBranching.maxInt(i1, i2), i2);
    }

    @Test
    public void maxInt_test_1_1()
    {
        int i1 = 3, i2 = 7;
        Mockito.when(utilsMock.utilFunc1("Hello")).thenReturn(true);
        Mockito.when(utilsMock.utilFunc2()).thenReturn(true);

        Assertions.assertEquals(myBranching.maxInt(i1, i2), 0);
    }

    @Test
    public void ifElseExample_test_0()
    {
        Mockito.when(utilsMock.utilFunc2()).thenReturn(false);

        Assertions.assertEquals(myBranching.ifElseExample(), false);
    }

    @Test
    public void ifElseExample_test_1()
    {
        Mockito.when(utilsMock.utilFunc2()).thenReturn(true);

        Assertions.assertEquals(myBranching.ifElseExample(), true);
    }

    @Test
    public void switchExample_test_0_false()
    {
        int i = 0;
        Mockito.when(utilsMock.utilFunc2()).thenReturn(false);

        myBranching.switchExample(i);

        Mockito.verify(utilsMock, Mockito.times(0)).utilFunc1(anyString());
    }

    @Test
    public void switchExample_test_0_true()
    {
        int i = 0;

        Mockito.when(utilsMock.utilFunc2()).thenReturn(true);

        myBranching.switchExample(i);

        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc1(anyString());
    }

    @Test
    public void switchExample_test_1()
    {
        int i = 1;

        myBranching.switchExample(i);

        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc1(anyString());
        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc2();
    }

    @Test
    public void switchExample_test_2()
    {
        int i = 2;

        myBranching.switchExample(i);

        Mockito.verify(utilsMock, Mockito.times(0)).utilFunc1(anyString());
        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc2();
    }

}
