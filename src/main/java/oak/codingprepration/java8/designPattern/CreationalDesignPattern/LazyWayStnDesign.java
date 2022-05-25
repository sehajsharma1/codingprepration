package oak.codingprepration.java8.designPattern.CreationalDesignPattern;

public class LazyWayStnDesign
{
 
  private LazyWayStnDesign()
  {
    // private constructor
  }
 
  // Inner class to provide instance of class
  private static class BillPughSingleton
  {
    private static final LazyWayStnDesign INSTANCE = new LazyWayStnDesign();
  }
 
  public static LazyWayStnDesign getInstance()
  {
    return BillPughSingleton.INSTANCE;
  }
}
