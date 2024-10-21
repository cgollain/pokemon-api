package fr.efrei.pokemon.services;

import fr.efrei.pokemon.models.Pokemon;
import fr.efrei.pokemon.repositories.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {

	private final PokemonRepository pokemonRepository;

	@Autowired
	public PokemonService(PokemonRepository pokemonRepository) {
		this.pokemonRepository = pokemonRepository;
	}

	// Trajet de la donnée
	// Base de données -> Entité -> Repository -> Service -> Controller
	public List<Pokemon> findAll() {
		// SELECT * FROM pokemon;
		return pokemonRepository.findAll();
	}

	// Trajet de la donnée
	// Controller -> Service -> Repository -> Entité -> BDD
	public void save(Pokemon pokemon) {
		// INSERT INTO pokemon VALUES (:name, :level, :type);
		pokemonRepository.save(pokemon);
	}
}
