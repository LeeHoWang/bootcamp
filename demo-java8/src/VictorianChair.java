public class VictorianChair implements Chair {
  @Override
  public void sitOn() {
    System.out.println("Victorian Chair sitOn ...");
  }
  @Override
  public boolean hasLegs() {
    return true;
  }
}
