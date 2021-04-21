package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Film;
import DAO.FilmDAO;

@WebServlet("/amendFilm")
public class amendFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public amendFilm() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache");
	    response.setHeader("Pragma", "no-cache");
		FilmDAO filmDAO = FilmDAO.getFilmDAO();
		String userFilmName = request.getParameter("Title");
		int userFilmID = Integer.parseInt(request.getParameter("ID"));
		int userFilmYear = Integer.parseInt(request.getParameter("Year"));
		String userFilmDirector = request.getParameter("Director");
		String userFilmCast = request.getParameter("Cast");
		String userFilmReview = request.getParameter("Review");
		
		Film film = new Film(userFilmID, userFilmName, userFilmYear, userFilmDirector, userFilmCast, userFilmReview);
		
		String address = "";
		filmDAO.updateFilm(film);
		if(sameFilm(filmDAO.getFilmByID(userFilmID), film)) {
			address = "update-succeded.jsp";
		} else {
			address = "update-failed.jsp";
		}
			

		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
	    dispatcher.include(request, response);
	}
	
	private boolean sameFilm(Film oldFilm, Film newFilm) {
		if(oldFilm.getFilmID()==newFilm.getFilmID() &&
			oldFilm.getFilmTitle().equals(newFilm.getFilmTitle()) &&
			oldFilm.getFilmDirector().equals(newFilm.getFilmDirector()) &&
			oldFilm.getFilmCast().equals(newFilm.getFilmCast()) &&
			oldFilm.getFilmReview().equals(newFilm.getFilmReview()) &&
			oldFilm.getFilmYear()==newFilm.getFilmYear()) {
			return true;
		} else {
			return false;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
