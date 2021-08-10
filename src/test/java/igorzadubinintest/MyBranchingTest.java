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

    /**
     * Создание mock utilsMock на объект Utils
     * Создание объекта MyBranching
     * Установка возвращаемых значений для методов Utils#utilFunc1, Utils#utilFunc2
     */
    @BeforeEach
    public void init() {
        utilsMock = Mockito.mock(Utils.class);
        myBranching = new MyBranching(utilsMock);
        Mockito.when(utilsMock.utilFunc1(anyString())).thenReturn(true);
        Mockito.when(utilsMock.utilFunc2()).thenReturn(true);
    }

    /**
     * Проверка результата выполнения метода в зависимости от возможных реализаций {@link Utils}
     * Должно возвращаться большее из значений или 0, если Utils#utilFunc2 вернёт true;
     */
    @Test
    public void maxInt_Test() {
        final int i1 = 5, i2 = 10;

        Assertions.assertTrue(myBranching.maxInt(i1, i2) == 0);

        Mockito.when(utilsMock.utilFunc1(anyString())).thenReturn(false);
        Assertions.assertTrue(myBranching.maxInt(i1, i2) == 0);

        Mockito.when(utilsMock.utilFunc2()).thenReturn(false);
        Assertions.assertTrue(myBranching.maxInt(i1, i2) == (i1 >= i2 ? i1 : i2));

        Mockito.when(utilsMock.utilFunc1(anyString())).thenReturn(true);
        Assertions.assertTrue(myBranching.maxInt(i1, i2) == (i1 >= i2 ? i1 : i2));
    }

    /**
     * Проверка результата выполнения метода в зависимости от возможных реализаций {@link Utils}
     * Должно возвращаться true, если Utils#utilFunc2() возвращает true
     */
    @Test
    public void ifElseExample_Test() {
        Assertions.assertTrue(myBranching.ifElseExample());
        Mockito.when(utilsMock.utilFunc2()).thenReturn(false);
        Assertions.assertFalse(myBranching.ifElseExample());
    }

    /**
     * Проверка выполнения Utils#utilFunc1 и Utils#utilFunc2 при входящем i = 0
     */
    @Test
    public void switchExampleI0_Test() {
        myBranching.switchExample(0);
        utilFuncVerify();
    }

    /**
     * Проверка выполнения Utils#utilFunc1 и Utils#utilFunc2 при входящем i = 1
     */
    @Test
    public void switchExampleI1_Test() {
        myBranching.switchExample(1);
        utilFuncVerify();
    }

    /**
     * Проверка выполнения Utils#utilFunc1 и Utils#utilFunc2 при входящем i = 2
     */
    @Test
    public void switchExampleI2_Test() {
        myBranching.switchExample(2);
        utilFuncVerify();
    }

    /**
     * Метод для проверки выполнения Utils#utilFunc1 и Utils#utilFunc2
     */
    public void utilFuncVerify() {
        Mockito.verify(utilsMock).utilFunc1(anyString());
        Mockito.verify(utilsMock).utilFunc2();
    }
}
