import java.time.LocalDate;
import java.util.Objects;

public class Staff {
  private String id;
  private String name;
  private LocalDate employDate;

  public Staff(String id, String name, LocalDate employDate) {
    this.id = id;
    this.name = name;
    this.employDate = employDate;
  }

  public String getId() {
    return this.id;
  }

  public LocalDate getEmployDate() {
    return this.employDate;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!(obj instanceof Staff))
      return false;
    Staff staff = (Staff) obj;
    return this.id.equals(staff.getId()) //
        && this.name.equals(staff.getName())
        && this.employDate.equals(staff.getEmployDate());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name, this.employDate); // 3 data generate an int value
  }
}
