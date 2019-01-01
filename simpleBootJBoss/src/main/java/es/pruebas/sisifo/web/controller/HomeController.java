package es.pruebas.sisifo.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@Value("${internal-key}")
	private String internalProperty;

	@Value("${external-key}")
	private String externalProperty;


	@RequestMapping("/home")
	public ModelAndView viewHome() {
		final ModelAndView mav = new ModelAndView("home");
		mav.addObject("mensaje", "Hello world");
		mav.addObject("internalProperty", internalProperty);
		mav.addObject("externalProperty", externalProperty);
		return mav;
	}
}
