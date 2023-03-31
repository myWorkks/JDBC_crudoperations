package com.marolix;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDemo {

	public static void main(String[] args) {
		// load the driver class
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/marolix", "root", "root");
			Statement st = con.createStatement();
			// int ss = st
			// .executeUpdate("create table student(std_rollno int primary key,std_name
			// varchar(30),class int );");
			// executeUpdate
			// executeQuery
			// execute
			// boolean ss = st.execute("drop table student;");
			// System.out.println(ss);
			 int i = st.executeUpdate("insert into student values(1,\"bharath\",1)");
//			int i= st.executeUpdate("update student set class=14 where std_rollno=1;");
			// System.out.println(i);

			// reading data

			ResultSet rs = st.executeQuery("select * from student");
			System.out.println("student details");
			System.out.println("------------------------------------");
			System.out.println("rollno " + "\t " + "name" + "\t" + "class");
			System.out.println("------------------------------------");
			while (rs.next()) {

				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3));
			}
			System.out.println("------------------------------------");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
