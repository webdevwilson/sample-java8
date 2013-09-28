package java8;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class BParallelStreamTest {

  @Test
  public void test_parallel() {
    
    List<TestScore> scores = Arrays.asList(lotsOfScores());

    final long start = System.currentTimeMillis();
    double average = scores.stream().mapToInt(item -> item.getScore()).average().getAsDouble();
    
    System.out.println("serial duration: " + (System.currentTimeMillis() - start) + " ms");
    
    final long parallelStart = System.currentTimeMillis();
    double secondAverage = scores.parallelStream().mapToInt(item -> item.getScore()).average().getAsDouble();
    
    System.out.println("parallel duration: " + (System.currentTimeMillis() - parallelStart) + " ms");
    
    assertThat(average, equalTo(secondAverage));
    
    double scoresOver90 = scores.parallelStream().mapToInt(item -> item.getScore()).filter(score -> score > 90).count();
    
    System.out.println("number of scores over 90: " + scoresOver90);
    System.out.println("percent of scores: " + (scoresOver90 / scores.size() * 100));
    
    assertThat(scoresOver90, not( equalTo(0) ) 
    );
  }
  
          
  public TestScore[] lotsOfScores() {
    final TestScore[] scores = new TestScore[10_000_000];
    for(int i=0; i < scores.length; i++) {
      scores[i] = new TestScore(Double.valueOf(Math.random() * 100 + 1).intValue());
    }
    return scores;
  }
}
