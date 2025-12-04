package it.unical.informatica.webapp24.recensioniristoranti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class TrasportoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrasportoApplication.class, args);
    }

}
