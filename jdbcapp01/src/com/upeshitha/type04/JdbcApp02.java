package com.upeshitha.type04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcApp02 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;	
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Eranda1234");
			st = con.createStatement();
			String query = "create table emp1(ENO number(3) primary key, ENAME varchar2(10), ESAL float(5),"
					+ "EADDR varchar2(10))";
			st.executeUpdate(query);
			System.out.println("Table emp1 created successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {		
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}					

	}

}
