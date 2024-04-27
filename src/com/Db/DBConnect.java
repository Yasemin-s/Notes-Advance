package com.Db;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

    private static Connection conn;

    public static Connection getConn() throws FileNotFoundException {
    	PrintWriter w= null;
        try {
        	w=new PrintWriter("D://log.txt");
            if(conn == null || conn.isClosed()) {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-2JP7ACI\\SQLEXPRESS;database=enotes2","dene","dene");
                w.print(conn.isClosed());
            }
        } catch(Exception e) {
        	
        	w.println(e.getMessage());
            e.printStackTrace();
            System.out.print(e.getMessage());
        }
        w.close();
        return conn;
    }
}