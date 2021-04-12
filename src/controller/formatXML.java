package controller;
import java.io.StringWriter;
import java.util.ArrayList;

import DAO.Film;
import DAO.FilmCollection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class formatXML {

	public static String createXML(ArrayList<Film> filmList) throws JAXBException {

        FilmCollection filmCollection = new FilmCollection();
        filmCollection.setFilmCollection(filmList);
        
		JAXBContext context = JAXBContext.newInstance(FilmCollection.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(filmCollection, stringWriter);
        
        return stringWriter.toString();
	}

}