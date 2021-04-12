package controller;

import java.io.IOException;
import java.io.PrintWriter;

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
		FilmDAO filmDAO = FilmDAO.getFilmDAO();
		int userFilmID = Integer.parseInt(request.getParameter("ID"));
		String title = filmDAO.getFilmByID(userFilmID).getFilmTitle();
		filmDAO.deleteFilm(userFilmID);
		PrintWriter out = response.getWriter();
		out.println("deleted " + title);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
