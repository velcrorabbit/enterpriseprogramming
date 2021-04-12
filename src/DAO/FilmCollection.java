package DAO;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

//This statement means that class "Bookstore.java" is the root-element of our example
@XmlRootElement(namespace = "DAO")
public class FilmCollection {

    @XmlElementWrapper(name = "filmList")
    @XmlElement(name = "film")
    private ArrayList<Film> filmList;

	public void setFilmCollection(ArrayList<Film> filmList) {
        this.filmList = filmList;
    }

    public ArrayList<Film> getFilmCollection() {
        return filmList;
    }

}