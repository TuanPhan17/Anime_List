package com.tuan.anime.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tuan.anime.models.Anime;
import com.tuan.anime.repositories.AnimeRepository;

@Service
public class AnimeService {

	private static AnimeRepository animeRepo;

	public AnimeService(AnimeRepository animeRepo) {
		this.animeRepo = animeRepo;
	}

	public Anime getOne(Long id) {
		Optional<Anime> anime = animeRepo.findById(id);
		return anime.isPresent() ? anime.get() : null;
	}

	public List<Anime> getAll() {
		return (List<Anime>) animeRepo.findAll();
	}

	public Anime create(Anime dojo) {
		return animeRepo.save(dojo);
	}

	public Anime update(Anime dojo) {
		return animeRepo.save(dojo);
	}

	public void delete(Long id) {
		animeRepo.deleteById(id);
	}

}