package think_like_a_programmer.c;

import java.io.IOException;
import java.io.InputStreamReader;

public class MessageDecoder {


  /*
  A message has been encoded as a text stream that is to be read character by character. The stream contains
a series of comma-delimited integers, each a positive number capable of being represented by a C++ int.
However, the character represented by a particular integer depends on the current decoding mode. There are
three modes: uppercase, lowercase, and punctuation.

In uppercase mode, each integer represents an uppercase letter: The integer modulo 27 indicates the letter
of the alphabet (where 1 = A and so on). So an input value of 143 in uppercase mode would yield the letter
H because 143 modulo 27 is 8 and H is the eighth letter in the alphabet.

The lowercase mode works the same but with lowercase letters; the remainder of dividing the integer by 27
represents the lowercase letter (1 = a and so on). So an input value of 56 in lowercase mode would yield the
letter b because 57 modulo 27 is 2 and b is the second letter in the alphabet.
In punctuation mode, the integer is instead considered modulo 9, with the interpretation given by Table 2-3
below. So 19 would yield an exclamation point because 19 modulo 9 is 1.

At the beginning of each message, the decoding mode is uppercase letters. Each time the modulo operation
(by 27 or 9, depending on mode) results in 0, the decoding mode switches. If the current mode is
uppercase, the mode switches to lowercase letters. If the current mode is lowercase, the mode switches to
punctuation, and if it is punctuation, it switches back to uppercase.
   */


  /*
  Написать код для считывания числа из символов строки.

  написать код, который переводит полученное число в букву или меняет режим считывания

  написать код, который переводит полученное число в знак препинания
   */


  public void decode() {
    try (var inputStreamReader = new InputStreamReader(System.in)) {
      char digitCharacterCode;
      var mode = Mode.UPPERCASE;
      String decodedMessage;
      StringBuilder stringBuilder = new StringBuilder();

      do {
        digitCharacterCode = (char) inputStreamReader.read();
        // преобразование кода символа в цифру, соотв этому символу
        int finalNumber = convertCharToInt(digitCharacterCode);

        digitCharacterCode = (char) inputStreamReader.read();

        while (digitCharacterCode != ',' && digitCharacterCode != 10) {
          finalNumber = finalNumber * 10 + convertCharToInt(digitCharacterCode);
          digitCharacterCode = (char) inputStreamReader.read();
        }

        int modulo;

        switch (mode) {
          case UPPERCASE:
            modulo = finalNumber % 27;
            if (modulo == 0) {
              mode = Mode.LOWERCASE;
              continue;
            }
            var character = convertNumberToUppercaseLetter(modulo);
            stringBuilder.append(character);
            break;
          case LOWERCASE:
            modulo = finalNumber % 27;
            if (modulo == 0) {
              mode = Mode.PUNCTUATION;
              continue;
            }
            character = convertNumberToLowercaseLetter(modulo);
            stringBuilder.append(character);
            break;
          case PUNCTUATION:
            modulo = finalNumber % 9;
            if (modulo == 0) {
              mode = Mode.UPPERCASE;
              continue;
            }
            character = convertNumberToPunctuationMark(modulo);
            stringBuilder.append(character);
        }

        System.out.println(stringBuilder);
      } while (digitCharacterCode != 10);
    } catch (IOException e) {}
  }

  private int convertCharToInt(char digitCharacterCode) {
    return digitCharacterCode - '0';
  }

  private char convertNumberToUppercaseLetter(int number) {
    return (char) (number + 'A' - 1);
  }

  private char convertNumberToLowercaseLetter(int number) {
    return (char) (number + 'a' - 1);
  }

  private char convertNumberToPunctuationMark(int number) {
    char punctuationMark = '^';
    switch (number) {
      case 1:
        punctuationMark = '!';
        break;
      case 2:
        punctuationMark = '?';
        break;
      case 3:
        punctuationMark = ',';
        break;
      case 4:
        punctuationMark = '.';
        break;
      case 5:
        punctuationMark = ' ';
        break;
      case 6:
        punctuationMark = ';';
        break;
      case 7:
        punctuationMark = '"';
        break;
      case 8:
        punctuationMark = '\'';
    }
    return punctuationMark;
  }

}
