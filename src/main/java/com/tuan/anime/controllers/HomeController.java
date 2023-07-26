package com.tuan.anime.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tuan.anime.services.AnimeService;
import com.tuan.anime.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	private final UserService userServ;
	private final AnimeService animeServ;
	public HomeController(UserService userServ,AnimeService animeServ) {
		this.userServ = userServ;
		this.animeServ = animeServ;
	}
	
	@GetMapping("/")
	public String home(HttpSession session, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/users/login/register";
		}
		model.addAttribute("allAnimes", animeServ.getAll());
		return "main/dashboard.jsp";
	}

}
