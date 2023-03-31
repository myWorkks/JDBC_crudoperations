package com.marolix;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class InsertPhoto {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bharath_demos", "root", "root");

		String query = "insert into photo_insert values(?,?)";
		Statement st = c.createStatement();
		PreparedStatement pst = c.prepareStatement(query);
		pst.setInt(1, 3);
		String path = "C:\\Users\\Dell\\OneDrive\\Pictures\\ACER\\about.png";
		String path2 = "C:\\Users\\Dell\\OneDrive\\Pictures\\ACER\\about";
		FileInputStream fis = new FileInputStream(new File(path));
		pst.setBlob(2, fis);
		//pst.execute();

		ResultSet rs = st.executeQuery("select * from photo_insert");
		while (rs.next()) {
			int i = rs.getInt(1);
			Blob b = rs.getBlob(2);
			byte[] byte1 = b.getBytes(1, (int) b.length());
			FileOutputStream fos = new FileOutputStream(new File(path2 + i + ".png"));
			fos.write(byte1);
			String ssss = path2 + i + ".png";
			System.out.println(ssss);
		}
		pst.close();
		c.close();
		System.out.println("inserted image");
	}
}
