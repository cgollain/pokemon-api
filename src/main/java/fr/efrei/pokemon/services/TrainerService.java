package fr.efrei.pokemon.services;

import fr.efrei.pokemon.models.Trainer;
import fr.efrei.pokemon.repositories.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerService {

	private final TrainerRepository repository;

	@Autowired
	public TrainerService(TrainerRepository repository) {
		this.repository = repository;
	}

	public List<Trainer> findAll() {
		return repository.findAll();
	}

	public Trainer findById(String id) {
		return repository.findById(id).orElse(null);
	}

	public void save(Trainer trainer) {
		repository.save(trainer);
	}
}
