package ChernovVD.branching;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ChernovVD.common.Utils;

import static org.mockito.ArgumentMatchers.anyString;

public class MyBranchingTest {
    /**
     * Проверка возвращаемого значения {@link MyBranching#maxInt(int, int)}.
     * Сценарий, при котором {@link Utils#utilFunc1(String)} и {@link Utils#utilFunc2()} возвращают
     * <code>false</code>.
     */
    @Test
    public void maxInt_Test1() {
        final int i1 = 2;
        final int i2 = 4;

        Utils utilsMock = Mockito.mock(Utils.class);

        Mockito.when(utilsMock.utilFunc1(anyString())).thenReturn(false);
        Mockito.when(utilsMock.utilFunc2()).thenReturn(false);

        MyBranching myBranching = new MyBranching(utilsMock);

        Assertions.assertEquals(i2, myBranching.maxInt(i1, i2));
    }

    /**
     * Проверка возвращаемого значения {@link MyBranching#maxInt(int, int)}.
     * Проверка количества вызовов методов {@link Utils#utilFunc1(String)} и {@link Utils#utilFunc2()}.
     * Сценарий, при котором {@link Utils#utilFunc1(String)} и {@link Utils#utilFunc2()} возвращают
     * <code>false</code> и <code>true</code> соответсвенно.
     */
    @Test
    public void maxInt_Test2() {
        final int i1 = 2;
        final int i2 = 4;

        Utils utilsMock = Mockito.mock(Utils.class);

        Mockito.when(utilsMock.utilFunc1(anyString())).thenReturn(false);
        Mockito.when(utilsMock.utilFunc2()).thenReturn(true);

        MyBranching myBranching = new MyBranching(utilsMock);

        Assertions.assertEquals(0, myBranching.maxInt(i1, i2));

        Mockito.verify(utilsMock, Mockito.times(4)).utilFunc1(anyString());
        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc2();
    }

    /**
     * Проверка возвращаемого значения {@link MyBranching#maxInt(int, int)}.
     * Проверка количества вызовов методов {@link Utils#utilFunc1(String)} и {@link Utils#utilFunc2()}.
     * Сценарий, при котором {@link Utils#utilFunc1(String)} и {@link Utils#utilFunc2()} возвращают
     * <code>true</code>.
     */
    @Test
    public void maxInt_Test3() {
        final int i1 = 2;
        final int i2 = 4;

        Utils utilsMock = Mockito.mock(Utils.class);

        Mockito.when(utilsMock.utilFunc1(anyString())).thenReturn(true);
        Mockito.when(utilsMock.utilFunc2()).thenReturn(true);

        MyBranching myBranching = new MyBranching(utilsMock);

        Assertions.assertEquals(0, myBranching.maxInt(i1, i2));

        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc1(anyString());
        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc2();
    }

    /**
     * Проверка возвращаемого значения {@link MyBranching#ifElseExample()}.
     * Проверка количества вызовов метода {@link Utils#utilFunc2()}.
     * Сценарий, при котором {@link Utils#utilFunc2()} возвращает
     * <code>true</code>.
     */
    @Test
    public void ifElseExample_Test1() {
        Utils utilsMock = Mockito.mock(Utils.class);

        Mockito.when(utilsMock.utilFunc2()).thenReturn(true);

        MyBranching myBranching = new MyBranching(utilsMock);
        Assertions.assertTrue(myBranching.ifElseExample());

        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc2();
    }

    /**
     * Проверка возвращаемого значения {@link MyBranching#ifElseExample()}.
     * Проверка количества вызовов метода {@link Utils#utilFunc2()}.
     * Сценарий, при котором {@link Utils#utilFunc2()} возвращает
     * <code>false</code>.
     */
    @Test
    public void ifElseExample_Test2() {
        Utils utilsMock = Mockito.mock(Utils.class);

        Mockito.when(utilsMock.utilFunc2()).thenReturn(false);

        MyBranching myBranching = new MyBranching(utilsMock);
        Assertions.assertFalse(myBranching.ifElseExample());

        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc2();
    }

    /**
     * Проверка количества вызовов методов {@link Utils#utilFunc1(String)} и {@link Utils#utilFunc2()}.
     * Сценарий, при котором {@link Utils#utilFunc1(String)} и {@link Utils#utilFunc2()} возвращают
     * <code>true</code>.
     */
    @Test
    public void switchExample_Test1() {
        final int i = 0;

        Utils utilsMock = Mockito.mock(Utils.class);

        Mockito.when(utilsMock.utilFunc1(anyString())).thenReturn(true);
        Mockito.when(utilsMock.utilFunc2()).thenReturn(true);

        MyBranching myBranching = new MyBranching(utilsMock);
        myBranching.switchExample(i);

        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc1(anyString());
        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc2();
    }

    /**
     * Проверка количества вызовов методов {@link Utils#utilFunc1(String)} и {@link Utils#utilFunc2()}.
     * Сценарий, при котором {@link Utils#utilFunc1(String)} и {@link Utils#utilFunc2()} возвращают
     * <code>true</code> и <code>false</code> соответственно.
     */
    @Test
    public void switchExample_Test2() {
        final int i = 0;

        Utils utilsMock = Mockito.mock(Utils.class);

        Mockito.when(utilsMock.utilFunc1(anyString())).thenReturn(true);
        Mockito.when(utilsMock.utilFunc2()).thenReturn(false);

        MyBranching myBranching = new MyBranching(utilsMock);
        myBranching.switchExample(i);

        Mockito.verify(utilsMock, Mockito.times(0)).utilFunc1(anyString());
        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc2();
    }

    /**
     * Проверка количества вызовов метода {@link Utils#utilFunc1(String)}.
     * Сценарий, при котором {@link Utils#utilFunc1(String)} возвращает
     * <code>true</code>.
     */
    @Test
    public void switchExample_Test3() {
        final int i = 1;

        Utils utilsMock = Mockito.mock(Utils.class);

        Mockito.when(utilsMock.utilFunc1(anyString())).thenReturn(true);

        MyBranching myBranching = new MyBranching(utilsMock);
        myBranching.switchExample(i);

        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc1(anyString());
    }

    /**
     * Проверка количества вызовов метода {@link Utils#utilFunc2()}.
     * Сценарий, при котором {@link Utils#utilFunc2()} возвращает
     * <code>true</code>.
     */
    @Test
    public void switchExample_Test4() {
        final int i = 2;

        Utils utilsMock = Mockito.mock(Utils.class);

        Mockito.when(utilsMock.utilFunc2()).thenReturn(true);

        MyBranching myBranching = new MyBranching(utilsMock);
        myBranching.switchExample(i);

        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc2();
    }
}
