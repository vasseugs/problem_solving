package b;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import think_like_a_programmer.b.LuhnNumberValidator;

@TestInstance(Lifecycle.PER_CLASS)
public class LuhnNumberValidatorTest {

  LuhnNumberValidator luhnNumberValidator;

  @BeforeAll
  void beforeAll() {
    luhnNumberValidator = new LuhnNumberValidator();
  }

  @ParameterizedTest
  @ValueSource(strings = {
      "1762483",
      "123456"
  })
  void isValid(String numberAsString) {
    var result = luhnNumberValidator.isValid(numberAsString);
    Assertions.assertTrue(result);
  }
}
