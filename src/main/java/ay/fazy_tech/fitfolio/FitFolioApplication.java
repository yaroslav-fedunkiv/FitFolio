package ay.fazy_tech.fitfolio;

import ay.fazy_tech.fitfolio.services.SerieService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FitFolioApplication {

    public static void main(String[] args) {
        SpringApplication.run(FitFolioApplication.class, args);
    }
    @Bean()
    CommandLineRunner init(SerieService serieService) {
        return args -> {
//            serieService.createSerie()
        };
    }

}
