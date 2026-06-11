public class ModernChair implements Chair {
  @Override
  public void sitOn() {
    System.out.println("Modern Chair sitOn ...");
  }
  @Override
  public boolean hasLegs() {
    return false;
  }
}
