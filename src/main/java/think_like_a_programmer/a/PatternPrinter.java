package think_like_a_programmer.a;

/**
 * Задачи по выводу в консоль разных узоров
 */


public class PatternPrinter {

  /*
  1.
   Вывести в консоль
   #####
   ####
   ###
   ##
   #
   */
  public static void half_square_twoLoops_1() {
    for (var row = 0; row < 5; row++) {
      for(var hashNum = 0; hashNum < 5 - row ; hashNum++) {
        System.out.print("#");
      }
      System.out.print("\n");
    }
  }

    /*
  2.
   Вывести в консоль
   #
   ##
   ###
   ####
   ###
   ##
   #
   */
  public static void square_quarter_stack_1() {
    for (var row = 1; row <= 7; row++) {
      for (var hashNum = 1; hashNum <= 4 - Math.abs(4 - row); hashNum++) {
        System.out.print("#");
      }
      System.out.print("\n");
    }
  }
}
