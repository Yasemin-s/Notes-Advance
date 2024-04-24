package com.Servlet;
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
