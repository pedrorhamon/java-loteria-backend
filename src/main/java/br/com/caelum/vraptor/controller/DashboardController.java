package br.com.caelum.vraptor.controller;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.UsuarioDAO;
import br.com.caelum.vraptor.model.Usuario;

@Path("dashboard")
@Controller
public class DashboardController {
	
	
	@Inject EntityManager em;
	@Inject Result resul;
	@Inject UsuarioDAO usuarioDAO;
	
	@Get("")
	public void dashboard() {
		
	}
	
	@Post("salvaUsuario")
	public void salvaUsuario(Usuario usuario) {
		usuarioDAO.insertOrUpdate(usuario);
		resul.redirectTo(DashboardController.class).dashboard();
	}
}
