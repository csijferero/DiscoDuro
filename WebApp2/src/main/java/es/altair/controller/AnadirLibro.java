package es.altair.controller;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import es.altair.bean.Libro;
import es.altair.bean.Usuario;
import es.altair.dao.LibroDAO;
import es.altair.dao.LibroDAOImplHibernate;

/**
 * Servlet implementation class AnadirLibro
 */
@MultipartConfig
public class AnadirLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AnadirLibro() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uuid = UUID.randomUUID().toString();
		String titulo = request.getParameter("titulo");
		String autor = request.getParameter("autor");
		int isbn = Integer.parseInt(request.getParameter("isbn"));

		// Tratamiento de la imagen
		Part filePart = request.getPart("portada");

		InputStream inputS = null;
		ByteArrayOutputStream os = null;
		if (!getFileName(filePart).equals("")) {
			inputS = filePart.getInputStream();

			// Escalar la imagen
			BufferedImage imageBuffer = ImageIO.read(inputS);
			Image tmp = imageBuffer.getScaledInstance(640, 640, BufferedImage.SCALE_FAST);
			BufferedImage buffered = new BufferedImage(640, 640, BufferedImage.TYPE_INT_RGB);
			buffered.getGraphics().drawImage(tmp, 0, 0, null);

			os = new ByteArrayOutputStream();
			ImageIO.write(buffered, "jpg", os);
		}

		HttpSession sesion = request.getSession();

		LibroDAO lDAO = new LibroDAOImplHibernate();

		Libro l = new Libro(titulo, autor, isbn, os.toByteArray(), uuid, 
				((Usuario) sesion.getAttribute("usuLogeado")));
		
		lDAO.insertar(l);

		response.sendRedirect("jsp/principalUsu.jsp");

	}

	private String getFileName(Part filePart) {
		for (String content : filePart.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename"))
				return content.substring(content.indexOf("=") + 1).trim().replace("\"", "");
		}
		return null;
	}

}