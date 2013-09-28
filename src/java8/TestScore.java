package java8;

public class TestScore implements Grade {

  private final int score;

  public TestScore(int score) {
    this.score = score;
  }

  @Override
  public int getScore() {
    return score;
  }
  
}
