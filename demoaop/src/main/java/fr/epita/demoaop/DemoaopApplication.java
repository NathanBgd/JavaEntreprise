package fr.epita.demoaop;

import fr.epita.demoaop.model.Performance;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class DemoaopApplication {

    public static void main(String[] args) {
      ConfigurableApplicationContext context =  SpringApplication.run(DemoaopApplication.class, args);
      Performance performance =  context.getBean("badConcert", Performance.class);
      performance.perform();
    }

}
