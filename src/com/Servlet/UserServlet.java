/*package com.Servlet;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintWriter;
import java.sql.*;
import com.User.*;
import com.Db.*;
public class UserServlet {
	public List<UserDetails> liste(){
		List<UserDetails> l=new ArrayList<UserDetails>();
		Connection c;
		PreparedStatement prs;
		PrintWriter w= null;
		try {
			w=new PrintWriter("D://log2.txt");
			DBConnect db=new DBConnect();
			c=db.getConn();
			prs=c.prepareStatement("select * from [enotes2].[dbo].[user]");
			ResultSet rs=prs.executeQuery();
			while(rs.next()) {
				UserDetails user=new UserDetails();
				user.setName(rs.getString("name"));
				w.println(rs.getString("name"));
				l.add(user);
			}
		}
		catch(Exception ex) {
			w.println("ex"+ex.getMessage());
		}
		w.close();
		return l;
	}

}
-----
vei yazdırma 
<%=u.liste().get(0).getName() %>
*/
package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.Db.DBConnect;
import com.User.UserDetails;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String name = request.getParameter("fname");
		String email = request.getParameter("uemail");
		String password = request.getParameter("upassword");
				
		
		UserDetails us = new UserDetails();
		us.setName(name);
		us.setEmail(email);
		us.setPassword(password);
		
		UserDAO dao = new UserDAO(DBConnect.getConn());
		boolean f = dao.addUser(us);
		HttpSession session;
		
		if(f) {
			session = request.getSession();
			session.setAttribute("reg-success", "Registration Successfullyy");
			response.sendRedirect("register.jsp");
		}
		else {
			session = request.getSession();
			session.setAttribute("failed-msg", "Something went wrong on server");
			response.sendRedirect("register.jsp");
		}
		
	}
}

