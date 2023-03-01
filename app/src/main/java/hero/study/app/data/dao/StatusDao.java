package hero.study.app.data.dao;

import hero.study.app.data.model.Status;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusDao extends JpaRepository<Status, Integer> {
  Optional<Status> getStatusById(Integer statusId);
}
