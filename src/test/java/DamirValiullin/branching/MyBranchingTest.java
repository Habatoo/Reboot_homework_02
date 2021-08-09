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

    /**
     * Ожидаем возврат 7 (наибольшего числа)
     * при utilFunc1("Hello") == false и utilFunc2() == false
     * интерфейса {@link Utils}
     */
    @Test
    public void maxInt_test_0_0()
    {
        int i1 = 3, i2 = 7;
        Mockito.when(utilsMock.utilFunc1("Hello")).thenReturn(false);
        Mockito.when(utilsMock.utilFunc2()).thenReturn(false);

        Assertions.assertEquals(myBranching.maxInt(i1, i2), i2);
    }

    /**
     * Ожидаем возврат 0
     * при utilFunc1("Hello") == false и utilFunc2() == true
     * интерфейса {@link Utils}
     */
    @Test
    public void maxInt_test_0_1()
    {
        int i1 = 3, i2 = 7;
        Mockito.when(utilsMock.utilFunc1("Hello")).thenReturn(false);
        Mockito.when(utilsMock.utilFunc2()).thenReturn(true);

        Assertions.assertEquals(myBranching.maxInt(i1, i2), 0);
    }

    /**
     * Ожидаем возврат 7 (наибольшего числа)
     * при utilFunc1("Hello") == true и utilFunc2() == false
     * интерфейса {@link Utils}
     */
    @Test
    public void maxInt_test_1_0()
    {
        int i1 = 3, i2 = 7;
        Mockito.when(utilsMock.utilFunc1("Hello")).thenReturn(true);
        Mockito.when(utilsMock.utilFunc2()).thenReturn(false);

        Assertions.assertEquals(myBranching.maxInt(i1, i2), i2);
    }

    /**
     * Ожидаем возврат 0
     * при utilFunc1("Hello") == true и utilFunc2() == true
     * интерфейса {@link Utils}
     */
    @Test
    public void maxInt_test_1_1()
    {
        int i1 = 3, i2 = 7;
        Mockito.when(utilsMock.utilFunc1("Hello")).thenReturn(true);
        Mockito.when(utilsMock.utilFunc2()).thenReturn(true);

        Assertions.assertEquals(myBranching.maxInt(i1, i2), 0);
    }

    /**
     * Ожидаем false
     * при utilFunc2() == false
     * интерфейса {@link Utils}
     */
    @Test
    public void ifElseExample_test_0()
    {
        Mockito.when(utilsMock.utilFunc2()).thenReturn(false);

        Assertions.assertEquals(myBranching.ifElseExample(), false);
    }

    /**
     * Ожидаем true
     * при utilFunc2() == true
     * интерфейса {@link Utils}
     */
    @Test
    public void ifElseExample_test_1()
    {
        Mockito.when(utilsMock.utilFunc2()).thenReturn(true);

        Assertions.assertEquals(myBranching.ifElseExample(), true);
    }

    /**
     * Проверка количества обращений к {@link Utils}
     * при аргументе i == 0
     * и utilFunc2() == false
     * интерфейса {@link Utils}
     */
    @Test
    public void switchExample_test_0_false()
    {
        int i = 0;
        Mockito.when(utilsMock.utilFunc2()).thenReturn(false);

        myBranching.switchExample(i);

        Mockito.verify(utilsMock, Mockito.times(0)).utilFunc1(anyString());
    }

    /**
     * Проверка количества обращений к {@link Utils}
     * при аргументе i == 0
     * и utilFunc2() == true
     * интерфейса {@link Utils}
     */
    @Test
    public void switchExample_test_0_true()
    {
        int i = 0;

        Mockito.when(utilsMock.utilFunc2()).thenReturn(true);

        myBranching.switchExample(i);

        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc1(anyString());
    }

    /**
     * Проверка количества обращений к {@link Utils}
     * при аргументе i == 1
     * вне зависимости от возвращаемых значений
     * интерфейса {@link Utils}
     */
    @Test
    public void switchExample_test_1()
    {
        int i = 1;

        myBranching.switchExample(i);

        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc1(anyString());
        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc2();
    }

    /**
     * Проверка количества обращений к {@link Utils}
     * при аргументе i == 2
     * вне зависимости от возвращаемых значений
     * интерфейса {@link Utils}
     */
    @Test
    public void switchExample_test_2()
    {
        int i = 2;

        myBranching.switchExample(i);

        Mockito.verify(utilsMock, Mockito.times(0)).utilFunc1(anyString());
        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc2();
    }

}
