package optimizer;

import java.util.*;

public class MemoizedRodCutter extends RodCutter {
  
  private Map<Integer, MaxPriceAndCuts> cachedResults = new HashMap<>();
  
  @Override
  public MaxPriceAndCuts cutRods(int length, Map<Integer, Integer> prices) {
    
    if (!cachedResults.containsKey(length))
      cachedResults.put(length, super.cutRods(length, prices));
    
    return cachedResults.get(length);
  }
}