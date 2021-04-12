package controller;
import java.io.StringWriter;
import java.util.ArrayList;

import DAO.Film;
import DAO.FilmList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class formatXML {

	public static String createXML(ArrayList<Film> filmList) throws JAXBException {

		FilmList filmListObject = new FilmList();
		filmListObject.setFilmCollection(filmList);
        
		JAXBContext context = JAXBContext.newInstance(FilmList.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(filmListObject, stringWriter);
        
        String xml = stringWriter.toString();
        StringBuilder stringBuilder = new StringBuilder(xml);
        stringBuilder.replace(0, 55, "");
        
        return stringBuilder.toString();
	}

}