package DAO;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name= "filmList")
public class FilmList {

    private ArrayList<Film> filmList;
    
	public void setFilmCollection(ArrayList<Film> filmList) {
        this.filmList = filmList;
    }

    @XmlElement(name = "film")
    public ArrayList<Film> getFilmCollection() {
        return filmList;
    }

}