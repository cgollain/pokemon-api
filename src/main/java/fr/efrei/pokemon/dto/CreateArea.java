package fr.efrei.pokemon.dto;

import java.util.List;

public class CreateArea {

    private String name;
    private Integer minLevel;
    private Integer maxLevel;
    private List<String> avaiblePokemons;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMinLevel() {
        return minLevel;
    }

    public void setMinLevel(Integer minLevel) {
        this.minLevel = minLevel;
    }

    public Integer getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(Integer maxLevel) {
        this.maxLevel = maxLevel;
    }

    public List<String> getAvaiblePokemons() {
        return avaiblePokemons;
    }

    public void setAvaiblePokemons(List<String> avaiblePokemons) {
        this.avaiblePokemons = avaiblePokemons;
    }
}
