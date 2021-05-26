package com.upeshitha.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcApp03 {

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
			String primary_Key_Cols = "";
			String query = "";
			query = query + "create table " +tName + "(";
			int primary_Key_Count = 0;
			
			while (true) {
				System.out.print("Column Name: ");
				String col_Name = br.readLine();
				System.out.print("Column Data Type and Size: ");
				String col_Type_Size = br.readLine();
				System.out.print("Is it primary key column[yes/no] : ");
				String primary_Key_Option = br.readLine();
				if (primary_Key_Option.equalsIgnoreCase("yes")) {
					primary_Key_Count = primary_Key_Count + 1;
					if (primary_Key_Count == 1) {
						primary_Key_Cols = primary_Key_Cols + col_Name;
					} else {
						primary_Key_Cols = primary_Key_Cols + "," + col_Name;
					}
					
				}
				query = query + col_Name + " " + col_Type_Size;
				
				System.out.print("Onemore Column? [yes/no] : ");
				String option = br.readLine();
				if (option.equalsIgnoreCase("yes")) {
					query = query + ",";
					continue;
				} else {
					query = query + "," + "primary key(" + primary_Key_Cols +"))";
					break;
				}				
			}
			System.out.println(query);
			
			st.executeQuery(query);
			System.out.println("Table " +tName+ "created successfully");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				st.close();
				con.close();			
			} catch (Exception e2) {
				e2.printStackTrace();
			}				
		}
	}

}
