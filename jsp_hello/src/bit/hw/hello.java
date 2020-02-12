package bit.hw;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class hello
 */
@WebServlet("/bitcamp")
public class hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hello() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//콘솔에 출력됨
				System.out.println("Hello World . . .");

				response.setContentType("text/html; charset=euc-kr"); //(문자기반)스트림의 한 종류
				PrintWriter writer = response.getWriter();
				//웹브라우저에게 뿌리는것
				writer.println("<html>");
				writer.println("<head>");
				writer.println("<style>p1 {color: #ffd800;} ");
				writer.println("p2 { background: #ff0000;}");
				writer.println("</head>");
				writer.println("<body>");
				writer.println("<p1>안녕하세요.</p1><br>");
				writer.println("<p2>비트캠프입니다.</p2>");
				writer.println("</body>");
				writer.println("</html>");

				writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
