package com.marolix;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class Student {
	static int count;
	private Integer rollno;
	private String name;
	private Integer class_std;

	public Student(Integer rollno, String name, Integer class_std) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.class_std = class_std;
	}

	public Integer getRollno() {
		return rollno;
	}

	public void setRollno(Integer rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getClass_std() {
		return class_std;
	}

	public void setClass_std(Integer class_std) {
		this.class_std = class_std;
	}

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", class_std=" + class_std + "]";
	}

}

public class JdbcDemo2 {

	static int count;

	public static Statement createStatement() throws ClassNotFoundException, SQLException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/marolix", "root", "root");
	Statement st = c.createStatement();
	return st;
}
	public static void insertValues(Student s) {
		try {
			Statement st=	JdbcDemo2. createStatement();
			String s2 = "insert into student values(" + s.getRollno() + ",\"" + s.getName() + "\"," + s.getClass_std()
					+ ");";

			System.out.println(s2);
			int i = st.executeUpdate("insert into student values(" + s.getRollno() + ",\"" + s.getName() + "\","
					+ s.getClass_std() + ");");
			System.out.println(i);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static void readAllValues() throws SQLException {
		Connection c=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		c = DriverManager.getConnection("jdbc:mysql://localhost:3306/marolix", "root", "root");
			Statement st = c.createStatement();
			String s = "select * from student";
			System.out.println(s);
			ResultSet rs = st.executeQuery(s);
			List<Student> studentList = new ArrayList<>();
			while (rs.next()) {
				Student stdent = new Student(rs.getInt(1), rs.getString(2), rs.getInt(3));
				studentList.add(stdent);

			}
			System.out.println(studentList);
			for (Student student : studentList) {
				count++;
			}
			System.out.println("total number of students " + count);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		finally {
			if(c==null||!c.isClosed()) {
				c.close();
			}
		}
	}

	public static void readOneValue(int i) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/marolix", "root", "root");
			Statement st = c.createStatement();
			String s = "select * from student where std_rollno =" + i;
			System.out.println(s);
			ResultSet rs = st.executeQuery(s);
			List<Student> studentList = new ArrayList<>();
			while (rs.next()) {
				Student stdent = new Student(rs.getInt(1), rs.getString(2), rs.getInt(3));
				studentList.add(stdent);

			}

			for (Student student : studentList) {
				count++;
			}

			if (studentList.isEmpty())
				System.out.println("no records found for the search");
			else {
				System.out.println("fetched details of student with rollno " + i);
				System.out.println(studentList);
			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static void updatingExistingRecord(int rollno, int std_class) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/marolix", "root", "root");
			Statement st = c.createStatement();
			// update student set std_name="rahul" where std_rollno=4;
			String s = "update student set class= " + std_class + " where std_rollno=" + rollno + ";";
			System.out.println(s);
			int i = st.executeUpdate(s);

			if (i == 1) {
				System.out.println("details updated successfully as class=" + std_class + "for roll no " + rollno);
			} else
				System.out.println("couldnot update details");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static void deleteExistingRecord(int rollno) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/marolix", "root", "root");
			Statement st = c.createStatement();
			// update student set std_name="rahul" where std_rollno=4;
			String s = "delete from student" + " where std_rollno=" + rollno + ";";
			System.out.println(s);
			int i = st.executeUpdate(s);

			if (i == 1) {
				System.out.println("deleted successfully for roll no " + rollno);
			} else
				System.out.println("couldnot delete details");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static void deleteAllRecords() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/marolix", "root", "root");
			Statement st = c.createStatement();
			// update student set std_name="rahul" where std_rollno=4;
			String s = "delete from student ;";
			System.out.println(s);
			int i = st.executeUpdate(s);

			if (i >= 0) {
				System.out.println("deleted successfully ");
			} else
				System.out.println("couldnot delete details");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection c;

			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/marolix", "root", "root");

			Statement st = c.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Student s = new Student(4, "satya", 16);
		 //JdbcDemo2.insertValues(s);
		 //JdbcDemo2.readAllValues();

		// JdbcDemo2.readOneValue(4);
		// JdbcDemo2.updatingExistingRecord(1, 25);
		// JdbcDemo2.deleteExistingRecord(1);
		JdbcDemo2.deleteAllRecords();

		// crud opertions
	}

}
