package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@RestController
public class AnnotationController {

    @RequestMapping("/coach")
    public Coach coach() {
      ClassPathXmlApplicationContext context =
        new ClassPathXmlApplicationContext("applicationContext.xml");

      Coach theCoach = context.getBean("tennisCoach", Coach.class);

      System.out.println(theCoach.getDailyFortune());
      System.out.println(theCoach.getDailyWorkout());

      return theCoach;
    }
}
