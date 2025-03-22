package com.projeto.cartas;

import com.projeto.cartas.carta.Card;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@SpringBootApplication
@RestController
public class CartasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartasApplication.class, args);
	}

}
