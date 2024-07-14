package think_like_a_programmer.d;

import java.util.List;

public class Recursion_3 {
    public static void main(String[] args) {
        List<Integer> ints = List.of(1, -2, 3, -4, 5);
        int result = countNegative(ints);
        System.out.println(result);
    }

    /*
    Найти количество отрицательных значений в связном списке.

    Абстрактный план решения такой:

    С - список
    З - задача

    1. Если длина С минимальная, то сразу возвращаем ответ
    2. Используем рекурсивный вызов, чтобы получить ответ в задаче для "оставшегося" С.
       (С начинается уже со второго элемента)
    3. Проверить значение первого элемента урезанного списка
    4. Использовать результаты предыдущих 2 шагов, чтобы получить ответ в задаче для всего С.
     */
    private static int countNegative(List<Integer> integers) {
        if (integers.isEmpty()) {
            return 0;
        }
        int result = countNegative(integers.subList(1, integers.size()));
        if (integers.get(0) < 0) {
            result++;
        }
        return result;
    }
}
