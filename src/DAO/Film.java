package DAO;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "filmID", "filmTitle", "filmYear", "filmDirector", "filmCast", "filmReview" })

public class Film {
	int id;
	String title;
	int year;
	String director;
	String cast;
	String review;
	
	public Film() {
		super();
	}

	public Film(int id, String title, int year, String director, String cast, String review) {
		super();
		this.id = id;
		this.title = title;
		this.year = year;
		this.director = director;
		this.cast = cast;
		this.review = review;
	}
	
	public int getFilmID() {
		return id;
	}
	
	public void setFilmID(int filmID) {
		this.id = filmID;
	}
	
	public String getFilmTitle() {
		return title;
	}
	
	public void setFilmTitle(String filmTitle) {
		this.title = filmTitle;
	}
	
	public int getFilmYear() {
		return year;
	}
	
	public void setFilmYear(int filmYear) {
		this.year = filmYear;
	}
	
	public String getFilmDirector() {
		return director;
	}
	
	public void setFilmDirector(String filmDirector) {
		this.director = filmDirector;
	}
	
	public String getFilmCast() {
		return cast;
	}
	
	public void setFilmCast(String filmCast) {
		this.cast = filmCast;
	}
	
	public String getFilmReview() {
		return review;
	}
	
	public void setFilmReview(String filmReview) {
		this.review = filmReview;
	}
	
	@Override
	public String toString() {
		return "[ID = " + id + ", Title = " + title + ", Year = " + year + ", Director = "
				+ director + ", Cast = " + cast + ", Review = " + review + "]\n";
	}
}
