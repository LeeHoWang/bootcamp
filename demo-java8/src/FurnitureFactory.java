public interface FurnitureFactory {
  Chair createChair();
  Sofa createSofa();
  
  public static FurnitureFactory of(Furniture.Type type) {
    if (type == Furniture.Type.MODERN) {
      return new ModernFurnitureFactory();
    } else if (type == Furniture.Type.VICTORIAN) {
      return new VictorianFurnitureFactory();
    }
    throw new IllegalArgumentException("Furniture Factory Not Found.");
  }
}
