package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.ConnectionFactory;

public class TestaConexao {
	public static void main(String[] args) {
		Connection connection = new ConnectionFactory().getConnection();
		
	}
}
