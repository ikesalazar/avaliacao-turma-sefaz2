package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import entities.Usuario;

@ManagedBean(name = "LoginBean")
@SessionScoped
public class LoginBean {
	private String inputEmail;
	private String inputSenha;

	private List<Usuario> listaUsuarios;
	private Usuario usuario;
	private UsuarioDAO usuarioDAO;

	public LoginBean() {
		this.listaUsuarios = new ArrayList<Usuario>();
		this.usuario = new Usuario();
		this.usuarioDAO = new UsuarioDAOImpl();
	}

	public void entrar() {

		boolean logado = false;

		this.listaUsuarios = this.usuarioDAO.listarTodosUsuarios();

		for (Usuario usuarioPesquisa : listaUsuarios) {

			if (inputEmail != null && usuarioPesquisa.getEmail().equals(this.inputEmail) && inputSenha != null
					&& usuarioPesquisa.getSenha().equals(this.inputSenha)) {

				logado = true;
			}
		}

		if (logado) {
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Login Inválido!"));
		}

	}

	public void criarUsuario() {

		Usuario nUsuario = new Usuario();

		nUsuario.setNome(this.usuario.getNome());
		nUsuario.setEmail(this.usuario.getEmail());
		nUsuario.setSenha(this.usuario.getSenha());

		boolean existe = false;

		this.listaUsuarios = this.usuarioDAO.listarTodosUsuarios();

		for (Usuario usuarioPesquisa : listaUsuarios) {
			if (usuarioPesquisa.getEmail().equals(this.usuario.getEmail())) {
				existe = true;
			}
		}

		if (existe) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Usuario já existe!"));
		} else {
			this.usuarioDAO.inserir(nUsuario);

			this.usuario = new Usuario();
		}
	}

	public String getInputEmail() {
		return inputEmail;
	}

	public void setInputEmail(String inputEmail) {
		this.inputEmail = inputEmail;
	}

	public String getInputSenha() {
		return inputSenha;
	}

	public void setInputSenha(String inputSenha) {
		this.inputSenha = inputSenha;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getFluxoPagina() {
		return fluxoPagina;
	}

	public void setFluxoPagina(String fluxoPagina) {
		this.fluxoPagina = fluxoPagina;
	}

}
