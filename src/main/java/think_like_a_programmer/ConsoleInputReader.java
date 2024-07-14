package think_like_a_programmer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputReader {

  public static String readString(String greetingMessage) {
    String input = "Не удалось считать";

    try (var br = new BufferedReader(new InputStreamReader(System.in))) {
      System.out.println(greetingMessage);
      input = br.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return input;
  }
}
