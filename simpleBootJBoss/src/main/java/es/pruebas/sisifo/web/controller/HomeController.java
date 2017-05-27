package es.pruebas.sisifo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/")
	public ModelAndView viewHome() {
		final ModelAndView mav = new ModelAndView("home");
		mav.addObject("mensaje", "Hello world");
		return mav;
	}
}
