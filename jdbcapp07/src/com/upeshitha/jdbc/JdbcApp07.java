package com.upeshitha.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.OracleDriver;

public class JdbcApp07 {
	
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			OracleDriver driver = new OracleDriver();
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Eranda1234");
			st = con.createStatement();
			rs = st.executeQuery("select * from emp1");
			System.out.println("ENO\tENAME\tESAL\tEADDR");
			System.out.println("-------------------------");
			while (rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getFloat(3) + "\t");
				System.out.print(rs.getString(4) + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {		
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
