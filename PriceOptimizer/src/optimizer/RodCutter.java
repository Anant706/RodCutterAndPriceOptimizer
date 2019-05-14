package optimizer;

import java.util.*;

public class RodCutter {
  
  public MaxPriceAndCuts cutRods(int length, Map<Integer, Integer> prices) {
    
    MaxPriceAndCuts maxPriceAndCuts = new MaxPriceAndCuts(prices.getOrDefault(length, 0), List.of(length));
    
    for (int index = 1; index < length; index++) {
      
      MaxPriceAndCuts maxPriceAndCutsSplit1 = cutRods(index, prices);
      MaxPriceAndCuts maxPriceAndCutsSplit2 = cutRods(length - index, prices);
      
      int maxPrice = maxPriceAndCutsSplit1.getMaxPrice() + maxPriceAndCutsSplit2.getMaxPrice();
      
      if (maxPrice > maxPriceAndCuts.getMaxPrice()) {
        List<Integer> rodCuts = new ArrayList<>(maxPriceAndCutsSplit1.getCuts());
        rodCuts.addAll(maxPriceAndCutsSplit2.getCuts());
        
        maxPriceAndCuts = new MaxPriceAndCuts(maxPrice, rodCuts);
      }
    }
    
    return maxPriceAndCuts;
  }
}