package DAO;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "film")

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
    @XmlElement(name = "id")
	public int getFilmID() {
		return id;
	}
	
	public void setFilmID(int filmID) {
		this.id = filmID;
	}
    @XmlElement(name = "title")
	public String getFilmTitle() {
		return title;
	}
	
	public void setFilmTitle(String filmTitle) {
		this.title = filmTitle;
	}
    @XmlElement(name = "year")
	public int getFilmYear() {
		return year;
	}
	
	public void setFilmYear(int filmYear) {
		this.year = filmYear;
	}
    @XmlElement(name = "director")
	public String getFilmDirector() {
		return director;
	}
	
	public void setFilmDirector(String filmDirector) {
		this.director = filmDirector;
	}
    @XmlElement(name = "cast")
	public String getFilmCast() {
		return cast;
	}
	
	public void setFilmCast(String filmCast) {
		this.cast = filmCast;
	}
    @XmlElement(name = "review")
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
