/*package com.Db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	private static Connection conn;
	public static Connection getConn() {
	try {
		if(conn == null) {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enotes2","root","password");
		}
		
	}catch(Exception e) {
		e.printStackTrace();
	}
		return conn;
	}
}
*/
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
/*
index
<%@page import="java.sql.Connection" %>
<%@page import="com.Db.DBConnect" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <style type="text/css">
.back-img{
background:url("img/notes.jpg");
width:100%;
height:80vh;
background-repeat:no-repeat;
background-size:cover;
background-position: center;
background-attachment: fixed;
}
</style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <%@include file="all_component/allcss.jsp" %>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <%@include file="all_component/navbar.jsp" %>
        
        <%
        Connection conn = DBConnect.getConn();
        out.println("Connection: " + conn);
        %>
       
        <div class="container-fluid back-img">
  <div class="text-center">
  <h1 class="text-white"><i class="fa fa-book" aria-hidden="true"></i>  Welcome to ENotes</h1>
<a href="login.jsp" class="btn btn-light"><i class="fa fa-user" aria-hidden="true"></i>  Login</a>
<a href="register.jsp" class="btn btn-light"><i class="fa fa-user-plus" aria-hidden="true"></i>  Register</a>
  
  </div>

</div>
      <%@include file="all_component/footer.jsp" %> 
    </body>
</html>
*/
/*
diğer
<%@page import="java.sql.Connection" %>
<%@page import="com.Db.DBConnect" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
        <style type="text/css">
.back-img{
background:url("img/notes.jpg");
width:100%;
height:80vh;
background-repeat:no-repeat;
background-size:cover;
background-position: center;
background-attachment: fixed;
}
</style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <%@include file="all_component/allcss.jsp" %>
        <link rel="stylesheet" href="css/style.css">
</head>
<body>
<%@include file="all_component/navbar.jsp" %>
<%
    // DBConnect sınıfından bir bağlantı al
    Connection conn = com.Db.DBConnect.getConn();

    // Bağlantı durumunu kontrol et
    if (conn != null) {
        out.println("Connection successful!");
    } else {
        out.println("Connection failed!");
    }
%>

<div class="container-fluid back-img">
    <div class="text-center">
        <h1 class="text-white"><i class="fa fa-book" aria-hidden="true"></i>  Welcome to ENotes</h1>
        <a href="login.jsp" class="btn btn-light"><i class="fa fa-user" aria-hidden="true"></i>  Login</a>
        <a href="register.jsp" class="btn btn-light"><i class="fa fa-user-plus" aria-hidden="true"></i>  Register</a>
    </div>
</div>

<%@include file="all_component/footer.jsp" %>

</body>
</html>
*/