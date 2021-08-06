package br.com.caelum.vraptor.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.model.Usuario;

@Path("dashboard")
@Controller
public class DashboardController {
	
	@Get("")
	public void dashboard() {
		
	}
	
	@Post("salvaUsuario")
	public void salvaUsuario(Usuario usuario) {
		System.out.println(usuario.getNome());
		
		
	}
}
