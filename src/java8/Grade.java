package java8;

public interface Grade {

  int getScore();
  
  default <T> T calculate(final CalculateFunction<T> func) {
    return func.calculate(getScore());
  }
  
  default char getLetterGrade() {
    
    int score = getScore();
    if(score > 92) {
      return 'A';
    } else if (score > 84) {
      return 'B';
    } else if (score > 76) {
      return 'C';
    } else if (score > 68) {
      return 'D';
    } else {
      return 'F';
    }
  }
  
}
