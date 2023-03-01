package hero.study.app.data.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("hero.study.app.data.model")
@EnableJpaRepositories(value = "hero.study.app.data.dao")
@ComponentScan(value = {"hero.study.app.data.dao",
  "hero.study.app.data.repository.impl"})
public class AppConfiguration {}
