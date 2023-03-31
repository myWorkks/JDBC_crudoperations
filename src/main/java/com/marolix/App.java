package com.marolix;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

public class App {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {// loading driver
																						// Class
																						// staticmehod forName()
																						// com.mysql.cj.jdbc.Driver
		Class c = Class.forName("com.mysql.cj.jdbc.Driver");
		String s = c.getName();
		// establishing the connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/marolix", "root", "root");
		// cmmunication with db
		Statement statement = connection.createStatement();
		// requesting the required thing
		String name1 = "prathu";
		ResultSet rs = statement.executeQuery("select distinct * from student where name =\"prathu\";");
//will fetch result
//for (Method method : a) {
//	System.out.println(method);

//}
		while (rs.next()) {
			System.out.println(rs.getInt(1) + rs.getString(2));
		}
	}
}
