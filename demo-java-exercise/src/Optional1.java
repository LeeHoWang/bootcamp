import java.lang.foreign.Linker.Option;
import java.util.Optional;

public class Optional1<T> {
  private T t;

  private Optional1(T t){
    this.t = t;
  }

  // ! Generic: Static method has to write down the range of T
  public static <T> Optional1<T> of(T t) {
    return new Optional1<T>(t);
  }

  // empty()
  public static <T> Optional1<T> empty() {
    return new Optional1<T>(null);
  }

  public boolean isPresent() {
    return t != null;
  }

  public T get() {
    return this.t;
  }

  public T orElse(T elseValue){
    return t != null ? this.t : elseValue;
  }
  
    public static void main(String[] args) {
      Optional1<String> name = Optional1.of("John");
      Optional1<String> name2 = Optional1.empty();

      if (name.isPresent()){
        System.out.println(name.get());
      }

      // orElse
      Optional<String> oldvalue = Optional.empty();
      String value = oldvalue.orElse("Yo");
      System.out.println(value);

    }
}
