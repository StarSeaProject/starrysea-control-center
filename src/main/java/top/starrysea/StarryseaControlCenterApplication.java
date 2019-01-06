package top.starrysea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
public class StarryseaControlCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarryseaControlCenterApplication.class, args);
	}

}

