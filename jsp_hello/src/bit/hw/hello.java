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
		//�ֿܼ� ��µ�
				System.out.println("Hello World . . .");

				response.setContentType("text/html; charset=euc-kr"); //(���ڱ��)��Ʈ���� �� ����
				PrintWriter writer = response.getWriter();
				//������������ �Ѹ��°�
				writer.println("<html>");
				writer.println("<head>");
				writer.println("<style>p1 {color: #ffd800;} ");
				writer.println("p2 { background: #ff0000;}");
				writer.println("</head>");
				writer.println("<body>");
				writer.println("<p1>�ȳ��ϼ���.</p1><br>");
				writer.println("<p2>��Ʈķ���Դϴ�.</p2>");
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
