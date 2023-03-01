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
@Entity(name = "person")
@Table(
  name = "persons",
  schema = "hero_db_1235")
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "person_id", nullable = false)
  private Integer id;

  @Column(name = "first_name", nullable = false)
  private String firstName;

  @Column(name = "sur_name")
  private String surName;

  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Override
  public String toString() {
    return "Person{" +
      "id=" + id +
      ", firstName='" + firstName + '\'' +
      ", surName='" + surName + '\'' +
      ", lastName='" + lastName + '\'' +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Person)) {
      return false;
    }
    Person person = (Person) o;
    return getId().equals(person.getId()) && getFirstName().equals(person.getFirstName())
      && Objects.equals(getSurName(), person.getSurName()) && getLastName().equals(
      person.getLastName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getFirstName(), getSurName(), getLastName());
  }
}
