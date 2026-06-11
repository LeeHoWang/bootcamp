public class VictorianSofa implements Sofa {
  @Override
  public void sitOn() {
    System.out.println("Victorian Sofa sitOn ...");
  }
  @Override
  public boolean hasLegs() {
    return true;
  }
}
