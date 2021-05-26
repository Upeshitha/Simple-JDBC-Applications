package com.upeshitha.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

import oracle.jdbc.OracleDriver;

public class JdbcApp05 {

	public static void main(String[] args) {
		Scanner scanner = null;
		Connection con = null;
		Statement st = null;
		try {
			DriverManager.registerDriver(new OracleDriver());
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Eranda1234");
			st = con.createStatement();
			
			scanner = new Scanner(System.in);
			System.out.print("Salary Range: ");
			float sal_Range = scanner.nextFloat();
			System.out.print("Bonous Amount: ");
			int bonous_Amt = scanner.nextInt();
			
			int rowCount = st.executeUpdate("update emp1 set ESAL = ESAL + " + bonous_Amt + 
					" where ESAL < " + sal_Range);
			System.out.print("Records Updated: " + rowCount);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				scanner.close();
				st.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
