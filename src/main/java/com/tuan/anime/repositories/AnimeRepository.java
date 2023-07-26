package com.tuan.anime.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tuan.anime.models.Anime;

@Repository
public interface AnimeRepository extends CrudRepository<Anime, Long>{
	List<Anime> findAll();

}
