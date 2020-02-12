package edu.bit.ex;

import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContexListenerEx
 */
@WebListener
public class ContextListenerEx implements ServletContextListener {
	private static final long serialVersionUID = 1L;
       

    public ContextListenerEx() {
 
    }

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("-----contextDestroyed-----");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("-----contextInitialized-----");
	}
    
 

	
}
