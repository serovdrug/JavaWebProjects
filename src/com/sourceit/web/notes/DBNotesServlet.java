package com.sourceit.web.notes;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBNotesServlet extends NotesServlet{
	
	private Connection conn;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		try {
			initDb();
		} catch (Exception e) {
			throw new ServletException("Error connecting to Database", e);
		}
	}

	@Override
	public void destroy() {
		super.destroy();
		
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				System.err.println("Unable to close DB connection");
				e.printStackTrace();
			}
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setAttribute("users", getUsers());
		} catch (SQLException e) {
			System.err.println("Unable to get users");
		}
		
		super.doGet(req, resp);
	}
	
	private void initDb() throws SQLException, ClassNotFoundException{
		String path = getServletContext().getRealPath("/") + "/WEB-INF";
		String url = "jdbc:h2:"+path+"/test;IFEXISTS=TRUE";
		
		Class.forName("org.h2.Driver");
		
		conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
	}
	
	private List<String> getUsers() throws SQLException{
		Statement stmt = null;
		List<String> users = new ArrayList<String>();
		try {
		        stmt = conn.createStatement();
		        ResultSet rs = stmt.executeQuery("select username from users");
		        while (rs.next()) {
		            String username = rs.getString("username");
		            
		            users.add(username);
		        }
	    } finally {
	        if (stmt != null) { stmt.close(); }
	    }
		
		return users;
	}
}
