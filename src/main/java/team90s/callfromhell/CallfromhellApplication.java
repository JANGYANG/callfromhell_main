package team90s.callfromhell;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class CallfromhellApplication {

    public static void main(String[] args) {
        SpringApplication.run(CallfromhellApplication.class, args);
    }

}
