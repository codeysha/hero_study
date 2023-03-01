package hero.study.app.data.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "learner")
@Table(
  name = "learners",
  schema = "hero_db_1235")
public class Learner {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "person_id", nullable = false)
  private Person person;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "status_id", nullable = false)
  private Status status;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "degree_id", nullable = false)
  private Degree degree;

  @Override
  public String toString() {
    return "Learner{" +
      "id=" + id +
      ", person=" + person +
      ", status=" + status +
      ", degree=" + degree +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Learner)) {
      return false;
    }
    Learner learner = (Learner) o;
    return getId().equals(learner.getId()) && getPerson().equals(learner.getPerson())
      && getStatus().equals(learner.getStatus()) && getDegree().equals(learner.getDegree());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getPerson(), getStatus(), getDegree());
  }
}
