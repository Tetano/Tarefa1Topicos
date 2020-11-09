package br.unitins.topicos1.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.unitins.topicos1.model.Usuario;

public class TesteBanco {
		
	public static void main(String[] args) {
		Connection conn = getConnection();
	}
		private static Connection getConnection() {
			Usuario usuario;
			Connection conn = null;
		
			// Pesado -> String sql = "dsadsa"+ "sdfgsd";
			// Leve/Correto:
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO ");
			sql.append(" usuario ");
			sql.append("   (nome, cpf, email, senha ");
			sql.append("VALUES");
			sql.append("   ('Janio', '123', 'janiojunior@gmail.com', '123)");
			
			try {
				PreparedStatement stat = conn.prepareStatement(sql.toString());
				stat.setString(1, "Silvano");
				stat.setString(2, "222");
				stat.setString(3, "silvano@gmail.com");
				stat.setString(4, "123");
				
				stat.execute();
				// Efetivando a transação ( transação -> update, create, delete ).
				conn.commit();
				
			} catch (SQLException e1) {
				// Cancelando a transação
				try {
					conn.rollback();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//INSERT INTO usuario (nome,cpf,email,senha)
			//VALUES ('JANIO','123','janiojunior@gmail.com',123)
			
		try {
			// Registrando o driver ao postegre
			Class.forName("org.postgresql.Driver");
			// Estabelescendo a conexão com o bd de banco de dados
			 conn = DriverManager.getConnection("jdbc:postegresql://127.0.0.1:5332/emaidiadb", "topicos1", "123456");
			 //Obrigando a trabalhar com roolback
			 conn.setAutoCommit(false);
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			System.out.println("Erro ao registrar a conexão");
			e.printStackTrace();
		}
		return conn;
	}
}

