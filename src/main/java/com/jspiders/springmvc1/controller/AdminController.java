package com.jspiders.springmvc1.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import com.jspiders.springmvc1.pojo.AdminPOJO;
import com.jspiders.springmvc1.service.AdminService;


@Controller
public class AdminController {
	
	@Autowired
	private AdminService service;

	// Home controller
	@GetMapping("/home")
	public String home(@SessionAttribute(name = "login", required = false) AdminPOJO login, ModelMap map) {
//		if (login != null) {
			return "home";
//		}
//		map.addAttribute("msg", "Login to proceed..!!");
//		return "Login";
	}
	
	// Login Form Controller
		@GetMapping("/login")
		public String login() {
			return "AdminLogin";
		}

		// Login controller
		@PostMapping("/login")
		public String loginData(HttpServletRequest request, @RequestParam String username, @RequestParam String password,
				ModelMap map) {
			AdminPOJO admin = service.login(username, password);
			if (admin != null) {
				HttpSession session = request.getSession();
				session.setAttribute("login", admin);
				session.setMaxInactiveInterval(120);
				return "home";
			}
			map.addAttribute("msg", "Invalid username or password..!!");
			return "AdminLogin";
		}
		
		// Add Form controller
		@GetMapping("/add")
		public String add(@SessionAttribute(name = "login", required = false) AdminPOJO login, ModelMap map) {
//			if (login != null) {
				return "AdminAdd";
//			}
//			map.addAttribute("msg", "Login to proceed..!!");
//			return "Login";
		}

		// Add response controller
		@PostMapping("/add")
		public String addAdmin(@SessionAttribute(name = "login", required = false) AdminPOJO login,
				@RequestParam String name, @RequestParam String email, @RequestParam String username, @RequestParam String password, ModelMap map) {
//			if (login != null) {
				AdminPOJO admin = service.add(name, email, username, password);
				if (admin != null) {
					map.addAttribute("admin", admin);
					map.addAttribute("msg", "Books added successfully..!!");
				} else {
					map.addAttribute("msg", "Books not added..!!");
				}
				return "AdminAdd";
			}
//			map.addAttribute("msg", "Login to proceed..!!");
//			return "Login";

//		}
		
		// Search form controller
		@GetMapping("/search")
		public String search(@SessionAttribute(name = "login", required = false) AdminPOJO login, ModelMap map) {
			if (login != null) {
				return "AdminSearch";
			}
			map.addAttribute("msg", "Login to proceed..!!");
			return "AdminLogin";

		}

		// Search response controller
		@PostMapping("/search")
		public String searchData(@SessionAttribute(name = "login", required = false) AdminPOJO login,
				@RequestParam int id, ModelMap map) {
			if (login != null) {
				AdminPOJO admin = service.search(id);
				if (admin != null) {
					// success
					map.addAttribute("admin", admin);
					return "AdminSearch";
				}
				// failure
				map.addAttribute("msg", "Books data does not exist..!!");
				return "AdminSearch";
			}
			map.addAttribute("msg", "Login to proceed..!!");
			return "AdminLogin";

		}

		
		// Remove form controller
		@GetMapping("/remove")
		public String remove(@SessionAttribute(name = "login", required = false) AdminPOJO login, ModelMap map) {
			if (login != null) {
				List<AdminPOJO> admins = service.searchAll();
				map.addAttribute("admins", admins);
				return "AdminRemove";
			}
			map.addAttribute("msg", "Login to proceed..!!");
			return "AdminLogin";

		}

		// Remove response controller
		@PostMapping("/remove")
		public String removeData(@SessionAttribute(name = "login", required = false) AdminPOJO login,
				@RequestParam int id, ModelMap map) {
			if (login != null) {
				AdminPOJO admin = service.remove(id);
				if (admin != null) {
					// success
					List<AdminPOJO> admins = service.searchAll();
					map.addAttribute("admins", admins);
					map.addAttribute("msg", "Books removed successfully..!!");
					return "AdminRemove";
				}
				// failure
				List<AdminPOJO> admins = service.searchAll();
				map.addAttribute("admins", admins);
				map.addAttribute("msg", "Books data does not exist..!!");
				return "AdminRemove";
			}
			map.addAttribute("msg", "Login to proceed..!!");
			return "AdminLogin";

		}

		// Update form controller
		@PostMapping("/update")
		public String updateForm(@SessionAttribute(name = "login", required = false) AdminPOJO login,
				@RequestParam int id, ModelMap map) {
			if (login != null) {
				AdminPOJO admin = service.search(id);
				if (admin != null) {
					// success
					map.addAttribute("admin", admin);
				}
				// failure
				List<AdminPOJO> admins = service.searchAll();
				map.addAttribute("admins", admins);
				map.addAttribute("msg", "Books data does not exist..!!");
				return "AdminUpdate";
			}
			map.addAttribute("msg", "Login to proceed..!!");
			return "AdminLogin";

		}
		
		// Update Data controller
		@PostMapping("/updateData")
		public String updateData(@SessionAttribute(name = "login", required = false) AdminPOJO login,
				@RequestParam int id, @RequestParam String name, @RequestParam String email, @RequestParam String username, @RequestParam String password, ModelMap map) {
			if (login != null) {
				AdminPOJO admin = service.update(id, name, email, username, password);
				if (admin != null) {
					// success
					map.addAttribute("msg", "Books data updated successfully..!!");
					List<AdminPOJO> admins = service.searchAll();
					map.addAttribute("admins", admins);
					return "AdminUpdate";
				}
				// failure
				map.addAttribute("msg", "Books not updated..!!");
				List<AdminPOJO> admins = service.searchAll();
				map.addAttribute("admins", admins);
				return "AdminUpdate";
			}
			map.addAttribute("msg", "Login to proceed..!!");
			return "AdminLogin";

		}

		// logout controller
		@GetMapping("/logout")
		public String logout(HttpSession session, ModelMap map) {
			session.invalidate();
			map.addAttribute("msg", "Logged out successfully..!!");
			return "Login";
		}



}
