package com.sourceit.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
 
public class MainServlet extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
 
    		req.getRequestDispatcher("login.jsp").forward(req, resp);

    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	if("Tom".equals(req.getParameter("username"))){
    		req.setAttribute("name", req.getParameter("username"));
    		req.getRequestDispatcher("admin-pane.jsp").forward(req, resp);
    	} else {  	
    		resp.getWriter().append("Access Forbidden");
    	}
    }
// 
    
    public Date getDate(){
    	return new Date();
    }
}