package hero.study.app.data.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "status")
@Table(
  name = "status",
  schema = "${MYSQL_DATABASE}")
public class Status {
  @Id
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "description", nullable = false)
  private String description;

  @Override
  public String toString() {
    return "Status{" +
      "id=" + id +
      ", description='" + description + '\'' +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Status)) {
      return false;
    }
    Status status = (Status) o;
    return getId().equals(status.getId()) && getDescription().equals(status.getDescription());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getDescription());
  }
}
