package es.pruebas.sisifo.web.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.pruebas.sisifo.web.beans.ProvinciaBean;



@RestController
public class ProvinciasRestController {

	@RequestMapping("/provincias")
	public List<ProvinciaBean> provincias() {
		final List<ProvinciaBean> provincias = new ArrayList<>();
		provincias.add(new ProvinciaBean(1L, "A coruna"));
		provincias.add(new ProvinciaBean(2L, "Lugo"));
		provincias.add(new ProvinciaBean(3L, "Orense"));
		provincias.add(new ProvinciaBean(4L, "Pontevedra"));

		return provincias;
	}


}
