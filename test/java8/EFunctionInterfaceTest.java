package java8;

import org.junit.Test;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class EFunctionInterfaceTest {

  @Test
  public void use_FunctionInterface()
  {
    final TestScore testScore = new TestScore(96);
    final int tenPoint = testScore.calculate(score -> Math.round(score / 10));
    assertThat( tenPoint, equalTo(10) );
  }
  
}
