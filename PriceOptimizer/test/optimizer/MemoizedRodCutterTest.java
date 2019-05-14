package optimizer;

class MemoizedRodCutterTest extends RodCutterTest {
  
  @Override
  public MemoizedRodCutter createRodCutter() {
    return new MemoizedRodCutter();
  }
}