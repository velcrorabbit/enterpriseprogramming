package controller;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;


import DAO.Film;

public class formatJSON {

	private static JSONObject convertToJSON(Film film) {
		JSONObject filmDetails = new JSONObject();
		filmDetails.put("id", film.getFilmID());
		filmDetails.put("title", film.getFilmTitle());
		filmDetails.put("year", film.getFilmYear());
		filmDetails.put("director", film.getFilmDirector());
		filmDetails.put("cast", film.getFilmCast());
		filmDetails.put("review", film.getFilmReview());
		return filmDetails;
	}
	
	public static JSONArray collectJsonObjects (ArrayList<Film> films) {
		JSONArray filmList = new JSONArray();
		for(Film film : films) {
			filmList.put(convertToJSON(film));
		}
		return filmList;
	}
}
