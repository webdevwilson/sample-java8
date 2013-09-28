package java8;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

public class ALambdaTest {

  @Test
  public void score_tests() {
    
    List<TestScore> scores = Arrays.asList(score(65), score(76), score(88), score(96), score(45), score(55), 
            score(87), score(45), score(90));
    
    final int max = scores.stream().mapToInt(i -> i.getScore()).max().getAsInt();
    assertEquals(max, 96);
    
    final double average = scores.stream().mapToInt(i -> i.getScore()).average().getAsDouble();
    assertEquals(average, 71.88D, .01D);
  }
          
  private TestScore score(int score) {
    return new TestScore(score);
  }
}
