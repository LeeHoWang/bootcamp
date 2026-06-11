public interface Furniture {
  void sitOn();
  boolean hasLegs();

  public static enum Type {
    VICTORIAN, MODERN,;
  }
}
