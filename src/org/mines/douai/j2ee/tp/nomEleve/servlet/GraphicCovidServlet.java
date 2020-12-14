package org.mines.douai.j2ee.tp.nomEleve.servlet;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GraphicCovidServlet
 */
@WebServlet("/GraphicCovid")
public class GraphicCovidServlet extends HttpServlet {
	private static final int NOMBRE_JOURS = 30;
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 500;
	private String selectedCountry = "France";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GraphicCovidServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("image/png");
		this.selectedCountry = request.getParameter("q");
		BufferedImage bufferedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = bufferedImage.createGraphics();

		// Draw on the image
		g2d.setColor(Color.red);
		for (int i = 0; i < NOMBRE_JOURS; i++) {
			int abscisse = i * WIDTH / 30;
			int ordonnee = HEIGHT - 2 - new Random().nextInt(HEIGHT);
			g2d.fill(new Ellipse2D.Float(abscisse, ordonnee, 2.5f, 2.5f));
		}

		ImageIO.write(bufferedImage, "png", response.getOutputStream());
		g2d.dispose();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
