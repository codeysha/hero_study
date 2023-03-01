package hero.study.app.data.dao;

import hero.study.app.data.model.Person;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDao extends JpaRepository<Person, Integer> {
  Optional<Person> getPersonById(Integer personId);
}
