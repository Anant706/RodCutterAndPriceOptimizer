package optimizer;

import java.util.*;

public class MaxPriceAndCuts {
  private final List<Integer> cuts;
  private final int maxPrice;

  public MaxPriceAndCuts(int price, List<Integer> rodLength) {
    maxPrice = price;
    cuts = rodLength;
  }

  public int getMaxPrice() {
    return maxPrice;
  }

  public List<Integer> getCuts() {
    return cuts;
  }
}
