package com.bridgelabz.JDBC;

import java.sql.*;
/**
 * @author Sachin Barpete
 * @purpose transaction management using commit and roll back
 */
public class TransactionManagement {

	public static void main(String[] args) throws Exception {

		String url = "jdbc:mysql://localhost:3306/bridgelabz";
		String user = "root";
		String pass = "password";
		int s_id = 20;
		String s_name = "barpete";
		String query = "insert into student values(?,?)";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, pass);
		con.setAutoCommit(false);
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, s_id);
		pst.setString(2, s_name);
		int count = pst.executeUpdate();
		System.out.println(count + " row/s effected");
		// con.rollback();
		con.commit();
		pst.close();
		con.close();

	}

}
