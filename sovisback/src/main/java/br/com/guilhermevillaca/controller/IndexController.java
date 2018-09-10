package br.com.guilhermevillaca.controller;
import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.guilhermevillaca.core.JsonResult;

@Controller
public class IndexController {

        @Inject 
        private JsonResult jsonResult;
        
	private final Result result;

	/**
	 * @deprecated CDI eyes only
	 */
	protected IndexController() {
		this(null);
	}
	
	@Inject
	public IndexController(Result result) {
		this.result = result;
	}

	@Path("/")
	public void index() {
		//result.include("variable", "VRaptor!");
                jsonResult.message("Olá mundo");
	}
}
