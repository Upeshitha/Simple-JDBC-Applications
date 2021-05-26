package com.upeshitha.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

import oracle.jdbc.OracleDriver;

public class JdbcApp06 {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		Scanner scanner = null;	
		try {
			DriverManager.registerDriver(new OracleDriver());
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Eranda1234");
			st = con.createStatement();
			
			scanner = new Scanner(System.in);
			System.out.print("Salary Range: ");
			float sal_Raange = scanner.nextFloat();
			
			int rowCount = st.executeUpdate("delete from emp1 where ESAL < " + sal_Raange);
			System.out.print("Recorde delected: " + rowCount);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				scanner.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
