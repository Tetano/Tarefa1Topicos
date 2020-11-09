package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;




// aula parou em: 2:13:34 -> Explicando o rollback após commit.
public class TesteBanco {
	
	public static void main(String[] args) {
		
		Connection conn = getConnection();

		// Usando StringBuffer P/ Concatenar Strings.
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO ");
		sql.append("usuario ");
		sql.append("  (nome, cpf, email, senha) ");
		sql.append("VALUES ");
		sql.append("  ( ?, ?, ?, ?) ");
		PreparedStatement stat = null;
		// Nunca passar por exemplo variavel -> sql.append(variavel). facilita sql injection.
		
		try {
			
			stat = conn.prepareStatement(sql.toString());
			
			// stat.setString() -> vai passar um tipo de variável para o banco
			stat.setString(1, "Silvano");
			stat.setString(2, "222");
			stat.setString(3, "silvano@gmail.com");
			stat.setString(4, "123");
			
			stat.execute(); // Executa os dados já setados 
			// Efetivando a transação
			conn.commit();
			System.out.println("Commit sucesso");
			Util.addMessage("Commit sucesso");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			// Cancelando a transacao
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("Erro ao realizar o rollback.");
				Util.addMessage("Erro ao realizar o rollback.");
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if(!stat.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Util.addMessage("Problema ao fechar conn");
				System.out.println("Problema ao fechar conn");
			}
			try {
				if(!conn.isClosed()) {
					stat.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Util.addMessage("Problema ao fechar statement");
				System.out.println("Problema ao fechar statement");
			}

		}
	}

	private static Connection getConnection() {
		
		//Transaçãoes de banco: Delete, Update e Insert (DIU)
		Connection conn = null;
		
	try {// Tentativa de execução do que estiver dentro do try
		
		// Registrando driver do postgres:
		Class.forName("org.postgresql.Driver");
		
		// Estabelescendo conexão com banco de dados;
		conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/emidiadb", "topicos1", "123456");
		
		//Obrigando a trabalhar com commit e rollback
		conn.setAutoCommit(false);
	
	} catch (SQLException e) {
		System.out.println("Erro ao conectar ao banco de dados.");
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
 catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
	 	System.out.println("Erro ao Registrar conexão");
		e.printStackTrace();
	}
	
	return conn;
	}

}
