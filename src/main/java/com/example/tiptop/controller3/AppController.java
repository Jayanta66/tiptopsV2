package com.example.tiptop.controller3;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.tiptop.beans.Job;
import com.example.tiptop.beans.User;
import com.example.tiptop.repository.UserRepository;
import com.example.tiptop.service.JobService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class AppController {
	@Autowired
	private JobService service;
	
	 	
//	@RequestMapping({"/","index"})
	@GetMapping
	public String viewHomePagee(Model model, @Param("keyword") String keyword) {
		List<Job> listProducts = service.listAll(keyword);

		int totaljob  = listProducts.size();

		model.addAttribute("totaljob", totaljob);
		model.addAttribute("listProducts", listProducts);
		model.addAttribute("keyword", keyword);
		
		return "index";
	}
	
	@RequestMapping("index")
	public String viewHomePage1(Model model, @Param("keyword") String keyword) {
		List<Job> listProducts = service.listAll(keyword);
		model.addAttribute("listProducts", listProducts);
		model.addAttribute("keyword", keyword);
		
		return "index";
	}
	
	
	
	@RequestMapping("joblist")
	public String viewHomePage(Model model, @Param("keyword") String keyword) {

		
		List<Job> listProducts = service.listAll(keyword);
		
		
		int totaljob  = listProducts.size();

		model.addAttribute("listProducts", listProducts);
		
		
		
		model.addAttribute("totaljob", totaljob);

		
		model.addAttribute("keyword", keyword);
		
		return "joblist";
	}
	
	
	
	
	@RequestMapping("/new")
	public String showNewProductForm(Model model) {
		Job product = new Job();
		model.addAttribute("product", product);
		
		return "new_product";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveJob(@ModelAttribute("joblist") Job joblist) {
		service.save(joblist);
		
		return "redirect:/joblist";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductForm(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit_product");
		
		Job product = service.get(id);
		mav.addObject("product", product);
		
		return mav;
	}	
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") Long id) {
		service.delete(id);
		
		return "redirect:/joblist";
	}
	

	@Autowired
	private UserRepository userRepository;
		

	@GetMapping({"/index"})
	public String home() {
		return "index";
		}
	

	


}
