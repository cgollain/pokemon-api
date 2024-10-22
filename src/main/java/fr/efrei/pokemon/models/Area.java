package fr.efrei.pokemon.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private int minLevel;

    private int maxLevel;

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

    public int getMinLevel() {
        return minLevel;
    }

    public void setMinLevel(int minLevel) {
        this.minLevel = minLevel;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    public List<Pokemon> getAvaiblePokemons() {
        return avaiblePokemons;
    }

    public void setAvaiblePokemons(List<Pokemon> avaiblePokemons) {
        this.avaiblePokemons = avaiblePokemons;
    }

}
