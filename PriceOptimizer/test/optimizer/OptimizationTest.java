package optimizer;

import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OptimizationTest {
  
  @Test
  public void testOptimizationForRodLengthFourteen() {
    assertTrue(computeTime(new RodCutter()) > computeTime(new MemoizedRodCutter()) * 10);
  }
  
  private long computeTime(RodCutter rodCutter) {
    Map<Integer, Integer> prices = Map.of(1, 1, 5, 4, 6, 5, 7, 5, 8, 9, 10, 10);
    long start = System.nanoTime();
    rodCutter.cutRods(14, prices);
    long end = System.nanoTime();
    return (end - start);
  }
}
