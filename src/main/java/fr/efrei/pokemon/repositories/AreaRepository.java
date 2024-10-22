package fr.efrei.pokemon.repositories;

import fr.efrei.pokemon.models.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends JpaRepository<Area, String> { }
