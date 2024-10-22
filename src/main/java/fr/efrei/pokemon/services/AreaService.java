package fr.efrei.pokemon.services;

import fr.efrei.pokemon.dto.CreateArea;
import fr.efrei.pokemon.dto.CreateTrainer;
import fr.efrei.pokemon.dto.UpdateArea;
import fr.efrei.pokemon.models.Area;
import fr.efrei.pokemon.models.Pokemon;
import fr.efrei.pokemon.models.Trainer;
import fr.efrei.pokemon.repositories.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;


@Service
public class AreaService {

    private final AreaRepository areaRepository;
    private final PokemonService pokemonService;

    @Autowired
    public AreaService(PokemonService pokemonService , AreaRepository areaRepository) {
        this.pokemonService = pokemonService;
        this.areaRepository = areaRepository;
    }

    public Area findById(String id) {
        return areaRepository.findById(id).orElse(null);
    }

    public List<Area> findAll() {
        return areaRepository.findAll();
    }

    public void save(CreateArea areaBody) {
        Area area = new Area();
        if (areaBody.getName() != null) {
            area.setName(areaBody.getName());
        }
        if (areaBody.getMinLevel() != null) {
            area.setMinLevel(areaBody.getMinLevel());
        }
        if (areaBody.getMaxLevel() != null) {
            area.setMaxLevel(areaBody.getMaxLevel());
        }
        // On récupère la liste des ids des pokemon du body postman
        List<String> pokemonIds = areaBody.getAvaiblePokemons();
        // On déclare une nouvelle liste de pokemon
        List<Pokemon> pokemonAAjouter = new ArrayList<>();
        // pour chaque id de pokemon dans ma liste d'id
        for (String idPokemon: pokemonIds) {
            // je récupere le pokemon avec l'id courant
            Pokemon pokemon = pokemonService.findById(idPokemon);
            // si le pokemon existe
            if(pokemon != null) {
                // je l'ajoute a ma liste de pokemon
                pokemonAAjouter.add(pokemon);
            }
        }
        // j'applique la liste de pokemon au trainer que je créé
        area.setAvaiblePokemons(pokemonAAjouter);
        // pokemonIds.forEach(id -> pokemonService.findById(id));
        areaRepository.save(area);
    }

    public void delete(String id) {
        areaRepository.deleteById(id);
    }

    public void update(String id, UpdateArea areaBody) {
        Area area = findById(id);
        if (areaBody.getName() != null) {
            area.setName(areaBody.getName());
        }
        if (areaBody.getMinLevel() != null) {
            area.setMinLevel(areaBody.getMinLevel());
        }
        if (areaBody.getMaxLevel() != null) {
            area.setMaxLevel(areaBody.getMaxLevel());
        }
        if(areaBody.getAvaiblePokemons() != null && !areaBody.getAvaiblePokemons().isEmpty()) {
            List<Pokemon> pokemonList = new ArrayList<>();
            List<String> pokemonIds = areaBody.getAvaiblePokemons();
            for(String idPokemon: pokemonIds) {
                Pokemon pokemon = pokemonService.findById(idPokemon);
                if(pokemon != null) {
                    pokemonList.add(pokemon);
                }
            }
            pokemonList.addAll(area.getAvaiblePokemons());
            area.setAvaiblePokemons(pokemonList);
        }
        areaRepository.save(area);
    }



}
