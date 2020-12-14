package org.mines.douai.j2ee.tp.nomEleve.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimpleCovidServlet
 */
@WebServlet("/SimpleCovid")
public class SimpleCovidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String FRANCE = "2 376 852";
	private static final String USA = "16 368 406";
	private static final String ALLEMAGNE = "1 350 810";

	private String selectedCountry = "France";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SimpleCovidServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<form action='http://localhost:8081/SimpleCovid/SimpleCovid' method=Post>");
		out.println("<select name='pays' id='pays'>\r\n");
		switch (this.selectedCountry) {
		case "France":
			out.println("<option value='France' selected='selected'>France</option>\r\n");
			out.println("<option value=\"USA\">USA</option>\r\n");
			out.println("<option value=\"Allemagne\">Allemagne</option>\r\n");
			break;
		case "Allemagne":
			out.println("<option value=\"France\">France</option>\r\n");
			out.println("<option value=\"USA\">USA</option>\r\n");
			out.println("<option value=\"Allemagne\" selected='selected'>Allemagne</option>\r\n");
			break;
		case "USA":
			out.println("<option value=\"France\">France</option>\r\n");
			out.println("<option value=\"USA\" selected='selected'>USA</option>\r\n");
			out.println("<option value=\"Allemagne\">Allemagne</option>\r\n");
			break;

		default:
			break;
		}
		out.println("</select>");

		out.println("<input type=submit name=Charger value=Charger>\r\n");
		out.println("</form>");

		switch (this.selectedCountry) {
		case "France":
			out.println(this.FRANCE);
			break;
		case "Allemagne":
			out.println(this.ALLEMAGNE);
			break;
		case "USA":
			out.println(this.USA);
			break;

		default:
			break;
		}
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.selectedCountry = request.getParameter("pays");
		doGet(request, response);

	}

}