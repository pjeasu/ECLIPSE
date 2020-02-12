package edu.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.bit.command.DeleteCommand;
import edu.bit.command.Bcommand;
import edu.bit.command.ContentCommand;
import edu.bit.command.ListCommand;
import edu.bit.command.ModifyCommand;
import edu.bit.command.ReplyCommand;
import edu.bit.command.ReplyViewCommand;
import edu.bit.command.WriteCommand;

/**
 * Servlet implementation class Controller
 */
@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void actionDo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("actionDo");
		req.setCharacterEncoding("EUC-KR");
		
		String viewPage = null;
		Bcommand command = null;
		
		String uri = req.getRequestURI();
		String conPath = req.getContextPath();
		String com = uri.substring(conPath.length());
		
		System.out.println("Å×½ºÆ® URI :" + uri + " : " + conPath + " : " + com);
		
		if(com.equals("/write_view.do")) {
			viewPage = "write_view.jsp";
		}else if(com.equals("/write.do")){
			command = new WriteCommand();
			command.execute(req, res);
			
			viewPage = "list.do";
		}else if(com.equals("/list.do")) {
			command = new ListCommand();
			command.execute(req, res);
			
			viewPage = "list.jsp";
		}else if(com.equals("/write.do")) {
			command = new WriteCommand();
			command.execute(req, res);
			
			viewPage = "write_view.jsp";
		}else if(com.equals("/content_view.do")) {
			command = new ContentCommand();
			command.execute(req, res);
			
			viewPage = "content_view.jsp";
		}else if(com.equals("/modify.do")) {
			command = new ModifyCommand();
			command.execute(req, res);
			
			viewPage = "list.do";
		}else if(com.equals("/delete.do")) {
			command = new DeleteCommand();
			command.execute(req, res);
			
			viewPage = "list.do";
		}else if(com.equals("/reply_view.do")) {
			command = new ReplyViewCommand();
			command.execute(req, res);
			
			viewPage = "reply_view.jsp";
		}else if(com.equals("/reply.do")) {
			command = new ReplyCommand();
			command.execute(req, res);
			
			viewPage = "list.do";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
		dispatcher.forward(req, res);
		
		
		
		
		
	}

}
