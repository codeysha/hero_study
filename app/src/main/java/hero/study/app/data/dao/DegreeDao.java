package hero.study.app.data.dao;

import hero.study.app.data.model.Degree;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DegreeDao extends JpaRepository<Degree, Integer> {
  Optional<Degree> getDegreeById(Integer degreeId);
}
