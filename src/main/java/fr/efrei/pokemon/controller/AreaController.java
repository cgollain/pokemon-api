package fr.efrei.pokemon.controller;

import fr.efrei.pokemon.dto.CreateArea;
import fr.efrei.pokemon.dto.CreateTrainer;
import fr.efrei.pokemon.dto.UpdateArea;
import fr.efrei.pokemon.dto.UpdateTrainer;
import fr.efrei.pokemon.models.Area;
import fr.efrei.pokemon.models.Pokemon;
import fr.efrei.pokemon.models.Trainer;
import fr.efrei.pokemon.services.AreaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/areas")
public class AreaController {

    private final AreaService areaService;

    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Area> findById(@PathVariable String id) {
        Area area = areaService.findById(id);
        if (area == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(area, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Area>> findAll() {
        return new ResponseEntity<>(areaService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody CreateArea area) {
        areaService.save(area);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody UpdateArea areaBody) {
        Area area = areaService.findById(id);
        if (area == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        areaService.update(id, areaBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Area area = areaService.findById(id);
        if (area == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        areaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
