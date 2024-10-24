package fr.efrei.pokemon.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private Integer minLevel;

    private Integer maxLevel;

    @OneToMany
    private List<Pokemon> avaiblePokemons;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
        return maxLevel; //(C'est le niveau max d'un pokemon pour une area)
    }

    public void setMaxLevel(Integer maxLevel) {
        this.maxLevel = maxLevel;
    }

    public List<Pokemon> getAvaiblePokemons() {
        return avaiblePokemons;
    }

    public void setAvaiblePokemons(List<Pokemon> avaiblePokemons) {
        this.avaiblePokemons = avaiblePokemons;
    }

}
