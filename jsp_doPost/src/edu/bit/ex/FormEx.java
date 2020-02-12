package edu.bit.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormEx
 */
@WebServlet("/FormEx")
public class FormEx extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormEx() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet");

//		String id = getInitParameter("id");
//		String pw = getInitParameter("pw");
//		String path = getInitParameter("path");

		String id = getServletContext().getInitParameter("id");
		String pw = getServletContext().getInitParameter("pw");
		String path = getServletContext().getInitParameter("path");

		response.setContentType("text/html; charset=euc-kr");
		PrintWriter writer = response.getWriter();

		writer.println("<html>");
		writer.println("<head>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("���̵� : " + id + "<br>");
		writer.println("��й�ȣ : " + pw + "<br>");
		writer.println("path : " + path + "<br>");

		writer.println("</body>");
		writer.println("</html>");

		writer.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dopost");
		req.setCharacterEncoding("EUC-KR");

		String id = req.getParameter("id"); 
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");

		String[] hobbys = req.getParameterValues("hobby"); // checkbox, �ߺ������� �����ؼ� �迭�� ����.

		String major = req.getParameter("major");
		String protocol = req.getParameter("protocol");

		response.setContentType("text/html; charset=euc-kr");
		PrintWriter writer = response.getWriter();

		writer.println("<html>");
		writer.println("<head>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("�̸� : " + name + "<br>");
		writer.println("���̵� : " + id + "<br>");
		writer.println("��й�ȣ : " + pw + "<br>");
		writer.println("���: " + Arrays.toString(hobbys) + "<br />");
		writer.println("����: " + major + "<br />");
		writer.println("��������: " + protocol);
		writer.println("</body>");
		writer.println("</html>");

		writer.close();

	}

}
