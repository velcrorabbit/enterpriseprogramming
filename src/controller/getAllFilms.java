package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

import org.json.JSONArray;

import DAO.Film;
import DAO.FilmDAO;

@WebServlet("/getAllFilms")
public class getAllFilms extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public getAllFilms() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		FilmDAO filmDAO = FilmDAO.getFilmDAO();
		ArrayList<Film> filmList = filmDAO.getAllFilms();
		String userDataType = request.getParameter("dataType");
		
		if (userDataType.equals("json")) {
			JSONArray filmJSON = formatJSON.collectJsonObjects(filmList);
			response.setContentType("application/json");
			out.println(filmJSON);
		} else if (userDataType.equals("xml")) {
			response.setContentType("text/xml");
			try {
				String xml = formatXML.createXML(filmList);
				out.println(xml);
			} catch (JAXBException e) {
				e.printStackTrace();
			}
		} else if (userDataType.equals("text")) {
			response.setContentType("text/plain");
			for (Film film : filmList) {
				out.println(film.toString());
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
