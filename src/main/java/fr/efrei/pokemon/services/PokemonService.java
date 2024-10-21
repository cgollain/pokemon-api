package fr.efrei.pokemon.services;

import fr.efrei.pokemon.repositories.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {

	private PokemonRepository pokemonRepository;

	@Autowired
	public PokemonService(PokemonRepository pokemonRepository) {
		this.pokemonRepository = pokemonRepository;
	}
}
