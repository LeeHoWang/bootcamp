public class User {
  private String username;
  private String password;

  // ! All argurement Constructor
  public User(String username) {
    this.username = username;
  }

  private User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public static Builder builder() {
    return new Builder();
  }

  public String getUsername() {
    return this.username;
  }

  public String getPassword() {
    return this.password;
  }

  // ! Builder Pattern
  public static class Builder {
    private String username;
    private String password;

    public Builder username(String username) {
      this.username = username;
      return this;
    }

    public Builder password(String password) {
      this.password = password;
      return this;
    }

    public User build() {
      return new User(this.username, this.password); // !  
    }
  }
  
  public static void main(String[] args) {
    // Drawbacks: 
    // 1. hard to place the right value into right parameter, in case there are 20+ parameters
    // 2. what if no password in day 1 for user object
    new User(null, null);

    // Solution (Builder Pattern)
    User u1 = User.builder() // return new Builder Object
      .username("johnlau") // return this (Builder Object)
      .password("admin1234") // return this (Builder Object)
      .build(); // return a new User Object
    System.out.println(u1.getUsername());
    System.out.println(u1.getPassword());

    User u2 = User.builder() //
      .username("marychan") //
      .build();
    System.out.println(u2.getUsername());
  }
}
