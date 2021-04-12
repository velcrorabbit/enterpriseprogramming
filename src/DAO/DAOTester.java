package DAO;

import java.util.ArrayList;

public class DAOTester {

	public static void main(String[] args) {
		FilmDAO filmData = new FilmDAO();
		
		Film testFilm = new Film(20000, "Test", 2020, "Rachel", "Rachie", "yes");

		ArrayList<Film> filmList = filmData.getAllFilms();
		
		for (Film film : filmList) {
			System.out.println(film.getFilmTitle());
		}
		
		ArrayList<Film> warFilmList = filmData.getFilmsByName("war");
		
		for (Film film : warFilmList) {
			System.out.println(film.getFilmTitle());
		}
		
		filmData.instertFilm(testFilm);
		System.out.println(testFilm.getFilmTitle());
		filmData.deleteFilm(20000);
		
	}

}
