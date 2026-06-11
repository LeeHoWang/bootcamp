public class BlackCoffee extends Coffee {  //
    
    public BlackCoffee(String name, double price) {
        super(name, price);
    }
    
    @Override
    public void addIngredient(Ingredient ingredient) {
        if (ingredient.getName().equals("Milk")) {
            System.out.println("Cannot add milk to black coffee.");
            return;
        }
        super.addIngredient(ingredient);  //
    }
}