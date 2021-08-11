package Laptenkov.branching;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import Laptenkov.sbp.branching.MyBranching;
import Laptenkov.sbp.common.Utils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.ArgumentMatchers.anyString;

public class MyBranchingTest {

    private MyBranching myBranching;
    private Utils utilsMock;

    final int iSmaller = 2;
    final int iBigger = 3;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    /**
     * Инициализация mock объекта {@link Utils} перед каждым запуском тестов.
     * Инициализация экземпляра тестируемого класса {@link MyBranching}.
     * Инициализация экземпляра класса {@link PrintStream} для контроля отображаемых сообщений.
     */
    @BeforeEach
    void setUp() {
        utilsMock = Mockito.mock(Utils.class);
        myBranching = new MyBranching(utilsMock);
        System.setOut(new PrintStream(outContent));
    }

    /**
     * Восстановление состояния переменной {@link MyBranchingTest#originalOut}
     * для контроля отображаемых сообщений.
     */
    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    /**
     * Проверка значения, которое возвращает метод {@link MyBranching#maxInt(int, int)},
     * при подаче 2-х входящих параметров типа int,
     * где {@link MyBranchingTest#iBigger} > {@link MyBranchingTest#iSmaller}.
     * <br>Проверка количества вызовов метода {@link Utils#utilFunc1(String)}.
     * <br>Сценарий, при котором {@link Utils#utilFunc1(String)} возвращает <code>true</code>,
     * {@link Utils#utilFunc2()} возвращает <code>true</code> должен возвращать 0.
     * @return - 0;
     */
    @Test
    void maxIntUtilFunc2TrueUtilFunc1True_Test() {

        Mockito.when(utilsMock.utilFunc2()).thenReturn(true);
        Mockito.when(utilsMock.utilFunc1("Hello")).thenReturn(true);
        int result = myBranching.maxInt(iSmaller, iBigger);
        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc1("Hello");
        Assertions.assertEquals(result, 0);

    }

    /**
     * Проверка значения, которое возвращает метод {@link MyBranching#maxInt(int, int)},
     * при подаче 2-х входящих параметров типа int,
     * где {@link MyBranchingTest#iBigger} > {@link MyBranchingTest#iSmaller}.
     * <br>Проверка количества вызовов метода {@link Utils#utilFunc1(String)}.
     * <br>Сценарий, при котором {@link Utils#utilFunc1(String)} возвращает <code>true</code>,
     * {@link Utils#utilFunc2()} возвращает <code>false</code> должен возвращать 0.
     * @return - 0;
     */
    @Test
    void maxIntUtilFunc2TrueUtilFunc1False_Test() {

        Mockito.when(utilsMock.utilFunc2()).thenReturn(true);
        Mockito.when(utilsMock.utilFunc1("Hello")).thenReturn(false);
        int result = myBranching.maxInt(iSmaller, iBigger);
        Mockito.verify(utilsMock, Mockito.times(iBigger)).utilFunc1(anyString());
        Assertions.assertEquals(result, 0);

    }

    /**
     * Проверка значения, которое возвращает метод {@link MyBranching#maxInt(int, int)},
     * при подаче 2-х входящих параметров типа int,
     * где {@link MyBranchingTest#iBigger} > {@link MyBranchingTest#iSmaller}.
     * <br>Проверка количества вызовов метода {@link Utils#utilFunc1(String)}.
     * <br>Сценарий, при котором {@link Utils#utilFunc2()} возвращает <code>false</code>
     * должен возвращать {@link MyBranchingTest#iBigger}.
     * @return - {@link MyBranchingTest#iBigger};
     */
    @Test
    void maxIntUtilFunc2False_Test() {

        Mockito.when(utilsMock.utilFunc2()).thenReturn(false);
        int result = myBranching.maxInt(iSmaller, iBigger);
        Mockito.verify(utilsMock, Mockito.times(0)).utilFunc1(anyString());
        Assertions.assertEquals(result, iBigger);

    }

    /**
     * Проверка значения, которое возвращает метод {@link MyBranching#ifElseExample()}
     * <br>Сценарий, при котором {@link Utils#utilFunc2()} возвращает <code>true</code>
     * должен возвращать <code>true</code>
     * и отображать в консоли сообщение "True!".
     * @return - <code>true</code>;
     */
    @Test
    void ifElseExampleTrue_Test() {
        Mockito.when(utilsMock.utilFunc2()).thenReturn(true);
        boolean result = myBranching.ifElseExample();
        Assertions.assertTrue(result);
        Assertions.assertEquals("True!", outContent.toString().trim());

    }

    /**
     * Проверка значения, которое возвращает метод {@link MyBranching#ifElseExample()}
     * <br>Сценарий, при котором {@link Utils#utilFunc2()} возвращает <code>false</code>
     * должен возвращать <code>false</code>
     * и отображать в консоли сообщение "False!".
     * @return - <code>false</code>;
     */
    @Test
    void ifElseExampleFalse_Test() {

        Mockito.when(utilsMock.utilFunc2()).thenReturn(false);
        boolean result = myBranching.ifElseExample();
        Assertions.assertFalse(result);
        Assertions.assertEquals("False!", outContent.toString().trim());

    }

    /**
     * Проверка метода {@link MyBranching#switchExample(int)}.
     * Проверка количества вызовов методов {@link Utils#utilFunc1(String)} и {@link Utils#utilFunc2()}.
     * <br>Сценарий, при котором в метод  {@link MyBranching#switchExample(int)}
     * подается входящий параметр типа int равный 1,
     * метод {@link Utils#utilFunc1(String)} возвращает <code>true</code>.
     * Методы {@link Utils#utilFunc1(String)} и {@link Utils#utilFunc2()} должны вызываться 1 раз.
     */
    @Test
    void switchExampleOne_Test() {

        Mockito.when(utilsMock.utilFunc1("abc")).thenReturn(true);
        myBranching.switchExample(1);
        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc1("abc");
        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc2();

    }

    /**
     * Проверка метода {@link MyBranching#switchExample(int)}.
     * Проверка количества вызовов методов {@link Utils#utilFunc1(String)} и {@link Utils#utilFunc2()}.
     * <br>Сценарий, при котором в метод  {@link MyBranching#switchExample(int)}
     * подается входящий параметр типа int равный 2,
     * метод {@link Utils#utilFunc1(String)} возвращает <code>true</code>.
     * Метод {@link Utils#utilFunc1(String)} должен вызываться 1 раз.
     * Метод {@link Utils#utilFunc2()} вызываться не должен.
     */
    @Test
    void switchExampleTwo_Test() {

        Mockito.when(utilsMock.utilFunc1("abc")).thenReturn(true);
        myBranching.switchExample(2);
        Mockito.verify(utilsMock, Mockito.times(0)).utilFunc1("abc");
        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc2();

    }

    /**
     * Проверка метода {@link MyBranching#switchExample(int)}.
     * Проверка количества вызовов методов {@link Utils#utilFunc1(String)} и {@link Utils#utilFunc2()}.
     * <br>Сценарий, при котором в метод  {@link MyBranching#switchExample(int)}
     * подается входящий параметр типа int равный -2 (отрицательное число),
     * метод {@link Utils#utilFunc2()} возвращает <code>true</code>,
     * метод {@link Utils#utilFunc1(String)} возвращает <code>true</code>.
     * Методы {@link Utils#utilFunc1(String)} и {@link Utils#utilFunc2()} должны вызываться 1 раз.
     */
    @Test
    void switchExampleMinusUtilFunc2True_Test() {

        Mockito.when(utilsMock.utilFunc2()).thenReturn(true);
        Mockito.when(utilsMock.utilFunc1("abc2")).thenReturn(true);
        myBranching.switchExample(-2);
        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc2();
        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc1("abc2");

    }

    /**
     * Проверка метода {@link MyBranching#switchExample(int)}.
     * Проверка количества вызовов методов {@link Utils#utilFunc1(String)} и {@link Utils#utilFunc2()}.
     * <br>Сценарий, при котором в метод  {@link MyBranching#switchExample(int)}
     * подается входящий параметр типа int равный -2 (отрицательное число),
     * метод {@link Utils#utilFunc2()} возвращает <code>false</code>,
     * метод {@link Utils#utilFunc1(String)} возвращает <code>true</code>.
     * Метод {@link Utils#utilFunc2()} должен вызываться 1 раз.
     * Метод {@link Utils#utilFunc1(String)} вызываться не должен.
     */
    @Test
    void switchExampleMinusUtilFunc2False_Test() {

        Mockito.when(utilsMock.utilFunc2()).thenReturn(false);
        Mockito.when(utilsMock.utilFunc1("abc2")).thenReturn(true);
        myBranching.switchExample(-2);
        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc2();
        Mockito.verify(utilsMock, Mockito.times(0)).utilFunc1("abc2");

    }

    /**
     * Проверка метода {@link MyBranching#switchExample(int)}.
     * Проверка количества вызовов методов {@link Utils#utilFunc1(String)} и {@link Utils#utilFunc2()}.
     * <br>Сценарий, при котором в метод  {@link MyBranching#switchExample(int)}
     * подается входящий параметр типа int равный 0,
     * метод {@link Utils#utilFunc2()} возвращает <code>true</code>,
     * метод {@link Utils#utilFunc1(String)} возвращает <code>true</code>.
     * Методы {@link Utils#utilFunc1(String)} и {@link Utils#utilFunc2()} должны вызываться 1 раз.
     */
    @Test
    void switchExampleZeroUtilFunc2True_Test() {
        Mockito.when(utilsMock.utilFunc2()).thenReturn(true);
        Mockito.when(utilsMock.utilFunc1("abc2")).thenReturn(true);
        myBranching.switchExample(0);
        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc2();
        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc1("abc2");

    }

    /**
     * Проверка метода {@link MyBranching#switchExample(int)}.
     * Проверка количества вызовов методов {@link Utils#utilFunc1(String)} и {@link Utils#utilFunc2()}.
     * <br>Сценарий, при котором в метод  {@link MyBranching#switchExample(int)}
     * подается входящий параметр типа int равный 0,
     * метод {@link Utils#utilFunc2()} возвращает <code>false</code>,
     * метод {@link Utils#utilFunc1(String)} возвращает <code>true</code>.
     * Метод {@link Utils#utilFunc2()} должен вызываться 1 раз.
     * Метод {@link Utils#utilFunc1(String)} вызываться не должен.
     */
    @Test
    void switchExampleZeroUtilFunc2False_Test() {
        Mockito.when(utilsMock.utilFunc2()).thenReturn(false);
        Mockito.when(utilsMock.utilFunc1("abc2")).thenReturn(true);
        myBranching.switchExample(0);
        Mockito.verify(utilsMock, Mockito.times(1)).utilFunc2();
        Mockito.verify(utilsMock, Mockito.times(0)).utilFunc1("abc2");

    }
}
