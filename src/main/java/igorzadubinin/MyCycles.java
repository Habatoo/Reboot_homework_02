package igorzadubinin;

import sbp.common.Utils;

public class MyCycles
{
    private final Utils utils;

    public MyCycles(Utils utils)
    {
        this.utils = utils;
    }

    /**
     * Необходимо написать реализацию метода с использованием for()
     +     * Метод должен вызвать Utils#utilFunc1() на каждой итерации
     +     * Реализация Utils#utilFunc1() неизвестна
     +     * Должна присутствовать проверка возврщаемого значения от Utils#utilFunc1()
     * Результат проверяется через unit-test (все тесты должны выполниться успешно)
     * @param iterations - количество итераций
     * @param str - строка для вывода через утилиту {@link Utils}
     */
    public void cycleForExample(int iterations, String str)
    {
        for (int i = 0; i < iterations; i++) {
            if (!utils.utilFunc1(str))
                break;
        }
    }

    /**
     * Необходимо написать реализацию метода с использованием for()
     +     * Метод должен вызвать Utils#utilFunc1() на каждой итерации
     +     * Реализация Utils#utilFunc1() неизвестна
     +     * Должна присутствовать проверка возврщаемого значения от Utils#utilFunc1()
     * Результат проверяется через unit-test (все тесты должны выполниться успешно)
     * @param iterations - количество итераций
     * @param str - строка для вывода через утилиту {@link Utils}
     */
    public void cycleWhileExample(int iterations, String str)
    {
        int i = 0;
        while (i < iterations) {
            if (!utils.utilFunc1(str))
                break;
            i++;
        }
    }

    /**
     * Необходимо написать реализацию метода с использованием while()
     -     * Метод должен вызвать Utils#printUtil() на каждой итерации
     -     * Реализация Utils#printUtil() неизвестна
     +     * Метод должен вызвать Utils#utilFunc1() на каждой итерации
     +     * Реализация Utils#utilFunc1() неизвестна
     * Должна присутствовать проверка возврщаемого значения
     * Результат проверяется через unit-test (все тесты должны выполниться успешно)
     * @param from - начальное значение итератора
     * @param to - конечное значение итератора
     * @param str - строка для вывода через утилиту {@link Utils}
     */
    public void cycleDoWhileExample(int from, int to, String str)
    {
        int i = from;
        do {
            if (!utils.utilFunc1(str))
                break;
            i--;
        }
        while(i >= to);
    }
}
