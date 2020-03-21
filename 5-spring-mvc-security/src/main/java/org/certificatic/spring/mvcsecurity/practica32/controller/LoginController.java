package org.certificatic.spring.mvcsecurity.practica32.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {

	// Anotar request mapping a "", "/" y "/login", por metodo GET
	@GetMapping({"", "/", "/login"})
	public String showLoginPage(Model model, 
			@RequestParam(required = false, value = "error") boolean error) {

		log.info("show login page ------------------");

		// Verificar si existe error en la autenticacion
		// Si existe error agregar mensaje de error al Modelo
		if(error) {
			log.info("login has error");
			model.addAttribute("errorMessage", "Wrong user or password");
		}
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		log.info("authentication: {}", auth);

		model.addAttribute("currentSecc", "login");

		return "login/view_login";
	}

	// Anotar request mapping a "/access-denied", por metodo GET
	@GetMapping("/access-denied")
	public String showAccessDeniedPage() {

		log.info("show access-denied page ------------------");

		return "login/view_access_denied";
	}

}
