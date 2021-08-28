package staples.heather.planbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import staples.heather.ComponentScanMarker;

@SpringBootApplication(scanBasePackageClasses = { ComponentScanMarker.class })
public class Planbook {

  public static void main(String[] args) {
    SpringApplication.run(Planbook.class, args);
  }
}