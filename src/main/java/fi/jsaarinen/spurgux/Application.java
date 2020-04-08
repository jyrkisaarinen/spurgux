package fi.jsaarinen.spurgux;

import java.util.Arrays;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Application implements WebApplicationInitializer
{
  @Override
  public void onStartup(ServletContext container)
  {
    AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
    ctx.register(WebMvcConfigurer.class);
    ctx.setServletContext(container);
    XmlWebApplicationContext appContext = new XmlWebApplicationContext();

    ServletRegistration.Dynamic registration = container.addServlet("spurgux", new SpurguXservlet(appContext));
    registration.setLoadOnStartup(1);
    registration.addMapping("/spurgux");
  }

  public static void main(String[] args)
  {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx)
  {
    {
      System.out.println("Let's inspect the beans provided by Spring Boot:");

      String[] beanNames = ctx.getBeanDefinitionNames();
      Arrays.sort(beanNames);
      for (String beanName : beanNames)
      {
        System.out.println(beanName);
      }

    }
    ;
    return null;
  }
}
