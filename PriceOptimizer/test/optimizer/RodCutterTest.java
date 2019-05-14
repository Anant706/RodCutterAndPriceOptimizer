package optimizer;

import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class RodCutterTest {
  private Map<Integer, Integer> prices = Map.of(1, 1, 2, 1, 3, 2, 4, 3, 5, 4, 6, 5, 7, 5, 8, 9, 10, 10);
  private RodCutter rodCutter;
  
  @BeforeEach
  void setUp() {
    rodCutter = createRodCutter();
  }
  
  public RodCutter createRodCutter() {
    return new RodCutter();
  }
  
  @Test
  public void canaryTest() {
    assertTrue(true);
  }
  
  @Test
  public void getPriceForRodLengthZero() {
    MaxPriceAndCuts maxPriceAndCuts = rodCutter.cutRods(0, prices);
    
    assertEquals(0, maxPriceAndCuts.getMaxPrice());
    assertEquals(List.of(0), maxPriceAndCuts.getCuts());
  }
  
  @Test
  public void getPriceForRodLengthOne() {
    MaxPriceAndCuts maxPriceAndCuts = rodCutter.cutRods(1, prices);
    
    assertEquals(1, maxPriceAndCuts.getMaxPrice());
    assertEquals(List.of(1), maxPriceAndCuts.getCuts());
  }
  
  @Test
  public void getPriceForRodLengthTwo() {
    MaxPriceAndCuts maxPriceAndCuts = rodCutter.cutRods(2, prices);
    
    assertEquals(2, maxPriceAndCuts.getMaxPrice());
    assertEquals(List.of(1, 1), maxPriceAndCuts.getCuts());
  }
  
  @Test
  public void getPriceForRodLengthThree() {
    MaxPriceAndCuts maxPriceAndCuts = rodCutter.cutRods(3, prices);
    
    assertEquals(3, maxPriceAndCuts.getMaxPrice());
    assertEquals(List.of(1, 1, 1), maxPriceAndCuts.getCuts());
  }
  
  @Test
  public void getPriceForRodLengthFive() {
    MaxPriceAndCuts maxPriceAndCuts = rodCutter.cutRods(5, prices);
    
    assertEquals(5, maxPriceAndCuts.getMaxPrice());
    assertEquals(List.of(1, 1, 1, 1, 1), maxPriceAndCuts.getCuts());
  }
  
  @Test
  public void getPriceForRodLengthTen() {
    MaxPriceAndCuts maxPriceAndCuts = rodCutter.cutRods(10, prices);
    
    assertEquals(11, maxPriceAndCuts.getMaxPrice());
    assertEquals(List.of(1, 1, 8), maxPriceAndCuts.getCuts());
  }
  
  @Test
  public void getPriceForRodLengthEleven() {
    MaxPriceAndCuts maxPriceAndCuts = rodCutter.cutRods(11, prices);
    
    assertEquals(12, maxPriceAndCuts.getMaxPrice());
    assertEquals(List.of(1, 1, 1, 8), maxPriceAndCuts.getCuts());
  }
  
  @Test
  public void getPriceForRodLengthFourteen() {
    MaxPriceAndCuts maxPriceAndCuts = rodCutter.cutRods(14, prices);
    
    assertEquals(15, maxPriceAndCuts.getMaxPrice());
    assertEquals(List.of(1, 1, 1, 1, 1, 1, 8), maxPriceAndCuts.getCuts());
  }
  
}
