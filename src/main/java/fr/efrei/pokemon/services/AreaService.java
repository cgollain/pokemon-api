package fr.efrei.pokemon.services;

import fr.efrei.pokemon.models.Area;
import fr.efrei.pokemon.repositories.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AreaService {

    private final AreaRepository areaRepository;
    private final PokemonService pokemonService;

    @Autowired
    public AreaService(PokemonService pokemonService , AreaRepository areaRepository) {
        this.pokemonService = pokemonService;
        this.areaRepository = areaRepository;
    }

    public void save(Area area) {
        // INSERT INTO pokemon VALUES (:name, :level, :type);
        areaRepository.save(area);
    }
}
