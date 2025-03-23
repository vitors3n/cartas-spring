package com.projeto.cartas.carta;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CardConfig {

    @Bean
    CommandLineRunner commandLineRunner(CardRepository repository) {
        return args -> {
            //Card artigo1 = new Card("Artigo 1", "Texto", 0);
            //Card artigo2 = new Card("Artigo 2", "Texto", 0);

            //repository.saveAll(
            //        List.of(artigo1, artigo2)
            //);
        };
    }
}
