package fr.efrei.pokemon.controller;


import fr.efrei.pokemon.models.Pokemon;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DefaultController {

	@GetMapping
	public Pokemon greetings() {
		Pokemon pokemon = new Pokemon();
		pokemon.setLevel(30);
		pokemon.setName("Ronflex");
		pokemon.setType("Normal");
		return pokemon;
	}
}
