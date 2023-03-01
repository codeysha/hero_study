package hero.study.app.dao;


import static org.junit.jupiter.api.Assertions.assertEquals;

import hero.study.app.data.dao.DegreeDao;
import hero.study.app.data.model.Degree;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;

@TestInstance(Lifecycle.PER_CLASS)
public class DegreeDaoTest extends CommonDaoTest {

  @Autowired
  private DegreeDao degreeDao;

  Degree testDegree = new Degree();

  @BeforeEach
  void prepareData()  {
    testDegree = degreeDao.save(
      Degree.builder()
        .description("test degree")
        .build()
    );
  }

  @Test
  @Order(1)
  void testCreateUpdateDelete() {

    Optional<Degree> savedDegree = degreeDao.getDegreeById(testDegree.getId());

    Degree testDegree2 = degreeDao.save(
      Degree.builder()
        .description("second degree")
        .build()
    );
    Optional<Degree> savedDegree2 = degreeDao.getDegreeById(testDegree2.getId());
    assertEquals(testDegree, savedDegree.orElse(null));
    assertEquals(testDegree2, savedDegree2.orElse(null));
  }
}
