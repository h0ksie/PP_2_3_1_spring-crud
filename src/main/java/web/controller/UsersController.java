package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UsersController {
	private final UserService userService;

	public UsersController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/")
	public String findAll(Model model) {
			model.addAttribute("users", userService.findAll());
		return "index";
	}
	@GetMapping("/{id}")
	public String findUser(@PathVariable("id") Long id, Model model) {
		model.addAttribute("user", userService.getUserById(id));
		return "user";
	}

	@PostMapping("/create")
	public String create(User user) {
		userService.create(user);
		return "redirect:/";
	}

	@PostMapping ("/{id}/update")
	public String update(@PathVariable("id") Long id,@ModelAttribute User user) {
		userService.update(id, user);
		return "redirect:/";
	}

	@PostMapping("/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		userService.delete(id);
		return "redirect:/";
	}

}