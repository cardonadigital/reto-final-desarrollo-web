package org.sofka.mykrello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Initial point to the app
 *
 * @author @author Daniel David Cardona - Paola Valentina
 * @version 1.0.0     30/07/2022
 * @since 1.0.0
 */
@SpringBootApplication
public class MyKrelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyKrelloApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


    /**
     * Configuration to handle the CORS policy
     * allowed all origins and methods
     *
     * @author Daniel David Cardona Moreno - Paola Valentina
     * @version 1.0.0 31/07/2022
     * @since 1.0.0
     */
    @Configuration
    public class CorsConfig {
        @Bean
        public WebMvcConfigurer corsConfigurer() {
            return new WebMvcConfigurer() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    registry.addMapping("/**").allowedOrigins("*")
                            .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE")
                            .allowedHeaders("*");
                }
            };
        }
    }
}
