package fr.efrei.pokemon.controller;

import fr.efrei.pokemon.models.Area;
import fr.efrei.pokemon.services.AreaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/areas")
public class AreaController {

    private final AreaService service;

    public AreaController(AreaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Area area) {
        service.save(area);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
