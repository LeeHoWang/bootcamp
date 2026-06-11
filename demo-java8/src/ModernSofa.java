public class ModernSofa implements Sofa {
  @Override
  public void sitOn() {
    System.out.println("Modern Sofa sitOn ...");
  }
  @Override
  public boolean hasLegs() {
    return false;
  }
}
