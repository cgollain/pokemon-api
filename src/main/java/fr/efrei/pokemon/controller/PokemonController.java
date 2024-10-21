package fr.efrei.pokemon.controller;

import fr.efrei.pokemon.models.Pokemon;
import fr.efrei.pokemon.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

	private final PokemonService service;

	@Autowired
	public PokemonController(PokemonService service) {
		this.service = service;
	}

	// GET
	@GetMapping
	public List<Pokemon> findAll() {
		return service.findAll();
	}

	// POST
	@PostMapping
	public void create(@RequestBody Pokemon pokemon) {
		service.save(pokemon);
	}

	// PUT

	// DELETE
}
