package com.upeshitha.app2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcApp02 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		BufferedReader br = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Eranda1234");
			st = con.createStatement();
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Table Name: ");
			String tName = br.readLine();
			String query = "create table " +tName +"(ENO number(3) primary key, ENAME varchar2(10), ESAL float(5),"
					+ "EADDR varchar2(10))";
			st.executeUpdate(query);
			System.out.println("Table " +tName+ "created successfully");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				st.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

	}

}
