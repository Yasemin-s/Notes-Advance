package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.User.Post;
import com.User.UserDetails;

public class PostDAO {

	private Connection conn;

	public PostDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean AddNotes(String ti,String co,int ui) {
		
		boolean f = false;
		
		try {
			
			String qu="insert into post(title,content,uid) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(qu);
			ps.setString(1, ti);
			ps.setString(2, co);
			ps.setInt(3, ui);
			
			int i = ps.executeUpdate();
			if(i == 1) {
				f = true;
			}
			
		}
		catch(Exception e) {
			
		}
		
		return f;
	}
	
}
