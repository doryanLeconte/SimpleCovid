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
	private String selectedCountry;

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
		if (request.getParameter("q") != null)
			this.selectedCountry = request.getParameter("q");
		else
			this.selectedCountry = "";
		BufferedImage bufferedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = bufferedImage.createGraphics();

		int allemagne = HEIGHT - NOMBRE_JOURS - new Random().nextInt(HEIGHT);
		int france = HEIGHT - NOMBRE_JOURS - new Random().nextInt(HEIGHT);
		int usa = HEIGHT - NOMBRE_JOURS - new Random().nextInt(HEIGHT);

		// Draw on the image

		switch (this.selectedCountry) {

		case ("France"):
			for (int i = 0; i < NOMBRE_JOURS; i++) {
				g2d.setColor(Color.BLUE);
				int abscisse = i * WIDTH / 30;
				int fluctuation = new Random().nextInt(100) - 50;
				int ordonnee = france + fluctuation;
				g2d.fill(new Ellipse2D.Float(abscisse, ordonnee, WIDTH / NOMBRE_JOURS, WIDTH / NOMBRE_JOURS));
			}
			break;
		case ("Allemagne"):
			for (int i = 0; i < NOMBRE_JOURS; i++) {
				g2d.setColor(Color.RED);
				int abscisse = i * WIDTH / 30;
				int fluctuation = new Random().nextInt(100) - 50;
				int ordonnee = allemagne + fluctuation;
				g2d.fill(new Ellipse2D.Float(abscisse, ordonnee, WIDTH / NOMBRE_JOURS, WIDTH / NOMBRE_JOURS));
			}
			break;
		case ("USA"):
			for (int i = 0; i < NOMBRE_JOURS; i++) {
				g2d.setColor(Color.GREEN);
				int abscisse = i * WIDTH / 30;
				int fluctuation = new Random().nextInt(100) - 50;
				int ordonnee = usa + fluctuation;
				g2d.fill(new Ellipse2D.Float(abscisse, ordonnee, WIDTH / NOMBRE_JOURS, WIDTH / NOMBRE_JOURS));
			}
			break;
		default:

			for (int i = 0; i < NOMBRE_JOURS; i++) {
				g2d.setColor(Color.RED);
				int abscisse = i * WIDTH / 30;
				int fluctuation = new Random().nextInt(100) - 50;
				int ordonnee = allemagne + fluctuation;
				g2d.fill(new Ellipse2D.Float(abscisse, ordonnee, WIDTH / NOMBRE_JOURS, WIDTH / NOMBRE_JOURS));
			}
			for (int i = 0; i < NOMBRE_JOURS; i++) {
				g2d.setColor(Color.BLUE);
				int abscisse = i * WIDTH / 30;
				int fluctuation = new Random().nextInt(100) - 50;
				int ordonnee = france + fluctuation;
				g2d.fill(new Ellipse2D.Float(abscisse, ordonnee, WIDTH / NOMBRE_JOURS, WIDTH / NOMBRE_JOURS));
			}
			for (int i = 0; i < NOMBRE_JOURS; i++) {
				g2d.setColor(Color.GREEN);
				int abscisse = i * WIDTH / 30;
				int fluctuation = new Random().nextInt(100) - 50;
				int ordonnee = usa + fluctuation;
				g2d.fill(new Ellipse2D.Float(abscisse, ordonnee, WIDTH / NOMBRE_JOURS, WIDTH / NOMBRE_JOURS));
			}
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
