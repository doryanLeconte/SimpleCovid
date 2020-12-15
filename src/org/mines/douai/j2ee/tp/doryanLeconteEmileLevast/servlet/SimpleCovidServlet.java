package org.mines.douai.j2ee.tp.doryanLeconteEmileLevast.servlet;

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
		out.println("<h1>Super CovidTracker!</h1>");
		out.println("<form action='./SimpleCovid' method=Post>");
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
			out.println("Nombre de cas du jour : " + this.FRANCE);
			out.println("</br><img src=./GraphicCovid?q=France>");
			break;
		case "Allemagne":
			out.println("Nombre de cas du jour : " + this.ALLEMAGNE);
			out.println("</br><img src=./GraphicCovid?q=Allemagne>");
			break;
		case "USA":
			out.println("Nombre de cas du jour : " + this.USA);
			out.println("</br><img src=./GraphicCovid?q=USA>");
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
