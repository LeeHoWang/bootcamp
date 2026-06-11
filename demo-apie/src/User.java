import java.util.Objects;

public class User {
  private String username; // unique

  public User(String username) {
    this.username = username;
  }

  public String getUsername() {
    return this.username;
  }

  @Override
  public boolean equals(Object obj) {
    // checking object address
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof User)) {
      return false;
    }
    User user = (User) obj;
    return this.username.equals(user.getUsername());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.username);
  }
}
