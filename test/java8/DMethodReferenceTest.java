package java8;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class DMethodReferenceTest {

  @Test
  public void sort_using_default_method() {
    
    final String[] numbers = new String[] { "0", "2", "1", "4", "3" };
    Arrays.sort(numbers, String::compareToIgnoreCase);
    
    assertThat(numbers[0], equalTo("0") );
    assertThat(numbers[1], equalTo("1") );
    assertThat(numbers[2], equalTo("2") );
    assertThat(numbers[3], equalTo("3") );
    assertThat(numbers[4], equalTo("4") );
  }
  
  @Test
  public void custom_default_converter() {
    
    final List<String> integerList = Arrays.asList("1", "2", "3", "4", "5");
    
    final int[] ints = integerList.stream().mapToInt(this::stringTimesTwo).toArray();
    assertThat( ints[0], equalTo(2) );
    assertThat( ints[1], equalTo(4) );
    assertThat( ints[2], equalTo(6) );
    assertThat( ints[3], equalTo(8) );
    assertThat( ints[4], equalTo(10) );
  }
  
  private int stringTimesTwo(String intStr) {
    return Integer.parseInt(intStr) * 2;
  }
  
}
