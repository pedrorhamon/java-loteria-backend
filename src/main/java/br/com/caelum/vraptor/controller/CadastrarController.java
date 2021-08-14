package br.com.caelum.vraptor.controller;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.UsuarioDAO;
import br.com.caelum.vraptor.model.Usuario;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;

@Path("cadastrar")
@Controller
public class CadastrarController {
	
	@Inject EntityManager em;
	@Inject Result resul;
	@Inject UsuarioDAO usuarioDAO;
	@Inject Validator validator;
	
	@Get("")
	public void cadastrar() {	
	}
	
	@Post("salvaUsuario")
	public void salvaUsuario(@Valid Usuario usuario, String confirmaSenha) {
		boolean asSenhasSaoIguais = confirmaSenha.equals(usuario.getSenha());
		validator.addIf(!asSenhasSaoIguais, new SimpleMessage("confirmaSenha", "A confirmação está diferente da senha"));
		validator.onErrorRedirectTo(this).cadastrar();
		usuarioDAO.insertOrUpdate(usuario);
		resul.redirectTo(DashboardController.class).dashboard();
	}
}
