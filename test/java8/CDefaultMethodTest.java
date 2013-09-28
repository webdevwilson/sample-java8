package java8;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class CDefaultMethodTest {

  @Test
  public void use_default_method() {
    
    TestScore test = new TestScore(85);
    assertThat( test.getLetterGrade(), equalTo('B') );
    
    
  }
  
}
