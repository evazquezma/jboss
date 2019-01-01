package es.pruebas.sisifo.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	@Value("${internal-key}")
	private String internalProperty;

	@Value("${external-key}")
	private String externalProperty;


	@RequestMapping("/home")
	public ModelAndView viewHome() {
		LOGGER.debug("Home controller");

		final ModelAndView mav = new ModelAndView("home");
		mav.addObject("mensaje", "Hello world");
		mav.addObject("internalProperty", internalProperty);
		mav.addObject("externalProperty", externalProperty);
		return mav;
	}
}
