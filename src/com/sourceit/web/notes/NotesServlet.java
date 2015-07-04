package com.sourceit.web.notes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NotesServlet extends HttpServlet{
	
	protected Map<String, List<String>> notes = new HashMap<String, List<String>>();

	
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("notes/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		
		
		List<String> list = notes.get(username);
		if(list == null){
			req.setAttribute("isNewUser", true);
			notes.put(username, new ArrayList<String>());
		}
		
		list = notes.get(username);
		String newNote = req.getParameter("newnote"); 
		if(newNote != null){
			list.add(newNote);
		}
		
		req.setAttribute("username", username);
		req.setAttribute("notesList", list);
		req.getRequestDispatcher("notes/notes.jsp").forward(req, resp);
	}
	

}
