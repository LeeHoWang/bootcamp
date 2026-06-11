public class Zoo<T extends Animal> {
  private T animal;

  public Zoo(T animal){
    this.animal = animal;
  }

  public void setAnimal(T animal) {
    this.animal = animal;
  }

  public static void main(String[] args) {
    Zoo<Tiger> tigerzoo = new Zoo<>(new Tiger());

    Zoo<Animal> animalZoo = new Zoo<>(new Tiger());
    animalZoo.setAnimal(new Lion());

    Zoo<Lion> lionZoo = new Zoo<>(new Lion());
  }
}
