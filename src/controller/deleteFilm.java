package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.FilmDAO;


@WebServlet("/deleteFilm")
public class deleteFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public deleteFilm() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache");
	    response.setHeader("Pragma", "no-cache");
		FilmDAO filmDAO = FilmDAO.getFilmDAO();
		int userFilmID = Integer.parseInt(request.getParameter("ID"));
		String address = "";
		if (filmDAO.getFilmByID(userFilmID) == null) {
			request.setAttribute("filmId", userFilmID);
			address = "delete-failed.jsp";
		} else {
			String title = filmDAO.getFilmByID(userFilmID).getFilmTitle();
			request.setAttribute("filmTitle", title);
			address = "delete-succeded.jsp";
			filmDAO.deleteFilm(userFilmID);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
	    dispatcher.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
