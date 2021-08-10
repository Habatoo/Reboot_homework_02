package ChernovVD.branching;

import ChernovVD.common.Utils;

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
        for (int i=0; i < iterations; i++) {
            boolean result = this.utils.utilFunc1(str);
            if (!result) {
                break;
            }
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
            boolean result = this.utils.utilFunc1(str);
            if (!result) {
                break;
            }

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
        int i = from < to ? from : to;
        int ii = from < to ? to : from;

        do {
            i++;

            boolean result = this.utils.utilFunc1(str);
            if (!result) {
                break;
            }

        } while (i != ii);
    }
}
