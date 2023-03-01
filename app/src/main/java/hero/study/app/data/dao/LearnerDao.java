package hero.study.app.data.dao;

import hero.study.app.data.model.Learner;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LearnerDao extends JpaRepository<Learner, Integer> {
  Optional<Learner> getLearnerById(Integer learnerId);
}
