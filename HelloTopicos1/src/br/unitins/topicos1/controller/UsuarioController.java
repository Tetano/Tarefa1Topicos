package br.unitins.topicos1.controller;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import test.*;



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
	
	
	private static Connection getConnection() {
		
		// Abre a conexão
		Connection conn = null;
		//Tentativa com try p/ executar código
			
			try {
				// 1- Registrar Driver Do PostGre	
				Class.forName("org.postgresql.Driver");
				
				// estabelecendo a conexão com banco de dados/ endereço/nome/senha
				
				conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/emidiadb", "topicos1", "123456");
			
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return conn;
		
	}

	public void incluir() {
		Connection conn = getConnection();

		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO ");
		sql.append("computadores ");
		sql.append("  (nome, cpf, email, senha) ");
		sql.append("VALUES ");
		sql.append("  ( ?, ?, ?, ?) ");
		PreparedStatement stat = null;
		try {
			Usuario usuario = getUsuario();
			stat = conn.prepareStatement(sql.toString());
			stat.setString(1, usuario.getNome()); // Usa o get para definir o nome
			stat.setString(2, usuario.getCpf());
			stat.setString(3, usuario.getEmail());
			stat.setString(4, usuario.getSenha());
			conn.setAutoCommit(false);
			stat.execute();
			// efetivando a transacao
			conn.commit();
			limpar();

		} catch (SQLException e) {
			e.printStackTrace();
			// cancelando a transacao
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.println("Erro ao realizar o rollback.");
				Util.addMessage("Erro ao realizar o rollback.");
				e1.printStackTrace();
			}
		} finally {
			try {
				if (!stat.isClosed())
					stat.close();
			} catch (SQLException e) {
				System.out.println("Erro ao fechar o Statement");
				Util.addMessage("Problema ao fechar conn");
				e.printStackTrace();
			}

			try {
				if (!conn.isClosed())
					conn.close();
			} catch (SQLException e) {
				Util.addMessage("Problema ao fechar statement");
				System.out.println("Erro a o fechar a conexao com o banco.");
				e.printStackTrace();
			}
		}

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
