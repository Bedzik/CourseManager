package pl.project.bednarski;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BednarskiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BednarskiApplication.class, args);
        System.out.println("Kompilacja klas zakończona sukcesem.");
    }
}
