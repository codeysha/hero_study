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
@Entity(name = "degree")
@Table(
  name = "degree",
  schema = "hero_db_1235")
public class Degree {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // todo: check auto incr
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "description")
  private String description;

  @Override
  public String toString() {
    return "Degree{" +
      "id=" + id +
      ", description='" + description + '\'' +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Degree)) {
      return false;
    }
    Degree degree = (Degree) o;
    return getId().equals(degree.getId()) && Objects.equals(getDescription(),
      degree.getDescription());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getDescription());
  }
}
