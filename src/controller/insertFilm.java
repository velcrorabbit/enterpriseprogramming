package controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Film;
import DAO.FilmDAO;

@WebServlet("/insertFilm")
public class insertFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public insertFilm() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FilmDAO filmDAO = FilmDAO.getFilmDAO();
		String userFilmName = request.getParameter("Title");
		int userFilmID = Integer.parseInt(request.getParameter("ID"));
		int userFilmYear = Integer.parseInt(request.getParameter("Year"));
		String userFilmDirector = request.getParameter("Director");
		String userFilmCast = request.getParameter("Cast");
		String userFilmReview = request.getParameter("Review");

		Film userFilm = new Film(userFilmID, userFilmName, userFilmYear, userFilmDirector, userFilmCast, userFilmReview);
		filmDAO.instertFilm(userFilm);
		PrintWriter out = response.getWriter();
		out.println("inserted " + userFilmName);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
