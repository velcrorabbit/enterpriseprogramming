package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

import org.json.JSONArray;

import DAO.Film;
import DAO.FilmDAO;

@WebServlet("/getFilm")
public class getFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public getFilm() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache");
	    response.setHeader("Pragma", "no-cache");
		String userFilmName = request.getParameter("filmName");
		String userDataType = request.getParameter("dataType").toUpperCase();
		
		FilmDAO filmDAO = FilmDAO.getFilmDAO();
		ArrayList<Film> filmList = filmDAO.getFilmsByName(userFilmName);

		String address = "/WEB-INF/views/";
		PrintWriter out = response.getWriter();
		if (filmList.isEmpty()) {
			
			address+= "noresults.jsp";
			
		} else if (userDataType.equals("JSON")) {
			JSONArray filmJSON = formatJSON.collectJsonObjects(filmList);
			response.setContentType("application/json");
			address += "json-page.jsp";
			request.setAttribute("films", filmJSON);
			
		} else if (userDataType.equals("XML")) {
			response.setContentType("text/xml");
			try {
				String xml = formatXML.createXML(filmList);
				address += "xml-page.jsp";
				request.setAttribute("films", xml);
				//System.out.println(xml);
				out.println(xml);
			} catch (JAXBException e) {
				e.printStackTrace();
			}
			
		} else if (userDataType.equals("TEXT")) {
			response.setContentType("text/plain");
			address += "text-page.jsp";
			String films = "";
			for (Film film : filmList) {
				films += film.toString();
			}
			request.setAttribute("films", films);
			
		}
		
	    RequestDispatcher dispatcher = request.getRequestDispatcher(address);
	    dispatcher.include(request, response);
	   
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
