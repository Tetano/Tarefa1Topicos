package br.unitins.topicos1.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import br.unitins.topicos1.model.Usuario;


@Named
@ViewScoped
//Pra usar ViewScoped tem que implementar Serializable
public class UsuarioController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4591906093154809069L;
	
	private Usuario usuario;
	private List<Usuario> listausuario;
	
	


	public void incluir() {
		getListausuario().add(getUsuario());
		limpar();
		System.out.println("Rodou");
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Inclusão realizada com sucesso"));
	}
	
	public void alterar() {
		
	}
	
	public void editar(Usuario usu) {
		setUsuario(usu);
	}
	
	public void excluir() {
		
	}

	public void limpar() {
		usuario = null;
		
	}
	
	public List<Usuario> getListausuario() {
		if(listausuario == null) {
			listausuario = new ArrayList<Usuario>();
		}
		return listausuario;
	}
	
	public Usuario getUsuario() {
		if(usuario == null) {
			usuario = new Usuario();
		}
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
