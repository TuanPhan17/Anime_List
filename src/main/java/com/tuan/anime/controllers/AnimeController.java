package com.tuan.anime.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tuan.anime.models.Anime;
import com.tuan.anime.services.AnimeService;
import com.tuan.anime.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/animes")
public class AnimeController {
	private final AnimeService animeServ;
	private final UserService userServ;

	public AnimeController(AnimeService animeServ,UserService userServ) {
		this.animeServ = animeServ;
		this.userServ = userServ;
	}

	@GetMapping("/create")
	public String createAnime(@ModelAttribute("anime") Anime anime) {
		return "anime/create.jsp";
	}

	@PostMapping("process/create")
	public String processCreateAnime(@Valid @ModelAttribute("anime") Anime anime, BindingResult result, HttpSession session) { 
		if(result.hasErrors()) {
			return "anime/create.jsp";
		}
		anime.setSeller(userServ.getUser((Long) session.getAttribute("user_id")));
		animeServ.create(anime);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String editAnime(@PathVariable("id") Long id, Model model) {
		model.addAttribute("anime", animeServ.getOne(id));
		return "anime/edit.jsp";
		
	}
	
	@PutMapping("process/edit/{id}")
	public String processEditAnime(@Valid @ModelAttribute("anime") Anime anime, BindingResult result) {
		if(result.hasErrors()) {
			return "anime/edit.jsp";
		}
		animeServ.update(anime);
		return "redirect:/";
	}
	
	@GetMapping("/{id}")
	public String displayAnime(@PathVariable("id") Long id, Model model) {
		model.addAttribute("anime", animeServ.getOne(id));
		return "anime/displayOne.jsp";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteAnime(@PathVariable("id") Long id) {
		animeServ.delete(id);
		return "redirect:/";
	}

}
