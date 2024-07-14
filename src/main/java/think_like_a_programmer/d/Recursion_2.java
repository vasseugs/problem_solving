package think_like_a_programmer.d;

/**
 *  Преобразование итеративного решения в рекурсивное.
 *  Ключевой тезис при построении рекурсивного решения -
 *  думать о рекурсивном вызове как о вызове другой функции, безотносительно
 *  того, как функция работает. Это упрощает сложность.
 *
 *  1. Имеем итеративное решение
 *  2. Создаем функцию-диспетчер, выполняющую минимально возможную работу
 *     (обрабатывает базовый случай)
 *  3. Вместо итеративной функции диспетчер начинает вызывать себя
 */
public class Recursion_2 {

  public static void main(String[] args) {
    int[] integers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    recursiveArraySumCommented(integers, integers.length);
  }

  /**
   * Чисто рекурсивный подход
   */
  private static int iterativeArraySum(int integers[], int size) {
    int sum = 0;
    for (int i = 0; i < size; i++) {
      sum += integers[i];
    }
    return sum;
  }

  /**
   * Вторая итерация - функция-диспетчер, которая умеет обрабатывать
   * базовый случай, и которая передает остальное решение задачи исходной
   * итеративной функции
   */
  private static int dispatcher(int integers[], int size) {
    if (size == 0) {
      return 0;
    }
    int lastNumber = integers[size - 1];
    int allButLastSum = iterativeArraySum(integers, size - 1);
    return lastNumber + allButLastSum;
  }

  /**
   * Итог - рекурсивная функция
   */
  private static int recursiveArraySum(int integers[], int size) {
    if (size == 0) {
      return 0;
    }
    int lastNumber = integers[size - 1];
    int allButLastSum = recursiveArraySum(integers, size - 1);
    return lastNumber + allButLastSum;
  }

  private static int recursiveArraySumCommented(int integers[], int size) {
    System.out.println("integers = " + size);
    if (size == 0) {
      System.out.println("size = 0");
      return 0;
    }
    int lastNumber = integers[size - 1];
    System.out.println("lastNumber = " + lastNumber);
    System.out.println("RECURSIVE CALL");
    int allButLastSum = recursiveArraySumCommented(integers, size - 1);
    System.out.println("RECURSIVE RETURN");
    System.out.println("allButLastSum = " + allButLastSum);
    return lastNumber + allButLastSum;
  }
}
