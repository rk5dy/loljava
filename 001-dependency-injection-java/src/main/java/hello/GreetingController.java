package hello;

import java.io.File;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        File curDir = new File(".");
        System.out.println(curDir.getAbsolutePath());
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @RequestMapping("/coach")
    public Coach coach() {
      ClassPathXmlApplicationContext context =
        new ClassPathXmlApplicationContext("applicationContext.xml");

      Coach theCoach = context.getBean("myCoach", Coach.class);

      System.out.println(theCoach.getDailyFortune());
      System.out.println(theCoach.getDailyWorkout());
      
      return theCoach;
    }

    private static void getAllFiles(File curDir) {
      File[] filesList = curDir.listFiles();
      for(File f : filesList){
          if(f.isDirectory())
              getAllFiles(f);
          if(f.isFile()){
              System.out.println(f.getName());
          }
      }
    }
}
