package java8;

@FunctionalInterface
public interface CalculateFunction<T> {
  
  T calculate(int score);
  
}
