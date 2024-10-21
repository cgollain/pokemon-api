package fr.efrei.pokemon.controller;

import fr.efrei.pokemon.models.Pokemon;
import fr.efrei.pokemon.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Pokemon>> findAll() {
		return new ResponseEntity< >(service.findAll(), HttpStatus.OK);
	}

	// POST
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Pokemon pokemon) {
		service.save(pokemon);
		return new ResponseEntity< >(HttpStatus.CREATED);
	}

	// PUT

	// DELETE
}
