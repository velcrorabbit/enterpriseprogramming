package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;

public class FilmDAO {

	private static FilmDAO instance = null;

	public static FilmDAO getFilmDAO() {
		if (instance == null) {
			instance = new FilmDAO();
		}
		return instance;
	}

	Film oneFilm = null;
	Connection connection = null;
	Statement statement = null;

	String user = "dodsonr";
	String password = "gretfaRn6";
	String url = "jdbc:mysql://mudfoot.doc.stu.mmu.ac.uk:6306/" + user;

	private void openConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();
		} catch (SQLException se) {
			System.out.println(se);
		}
	}

	private void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private Film getNextFilm(ResultSet resultSet) {
		Film thisFilm = null;
		try {
			thisFilm = new Film(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getInt("year"),
					resultSet.getString("director"), resultSet.getString("stars"), resultSet.getString("review"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return thisFilm;
	}

	public ArrayList<Film> getAllFilms() {

		ArrayList<Film> allFilms = new ArrayList<Film>();
		openConnection();

		try {
			String selectSQL = "SELECT * FROM films";
			ResultSet resultSetOne = statement.executeQuery(selectSQL);
			while (resultSetOne.next()) {
				oneFilm = getNextFilm(resultSetOne);
				allFilms.add(oneFilm);
			}

			statement.close();
			closeConnection();
		} catch (SQLException se) {
			System.out.println(se);
		}

		return allFilms;
	}

	public ArrayList<Film> getFilmsByName(String title) {

		openConnection();
		ArrayList<Film> filmsByName = new ArrayList<Film>();
		try {
			String selectSQL = "SELECT * FROM films WHERE title LIKE ?";
			PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, "%" + title.toUpperCase() + "%");
			ResultSet resultSetOne = preparedStatement.executeQuery();
			while (resultSetOne.next()) {
				oneFilm = getNextFilm(resultSetOne);
				filmsByName.add(oneFilm);
			}

			statement.close();
			closeConnection();
		} catch (SQLException se) {
			System.out.println(se);
		}

		return filmsByName;
	}

	public Film getFilmByID(int id) {

		openConnection();
		oneFilm = null;
		try {
			String selectSQL = "SELECT * FROM films WHERE id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);
			ResultSet resultSetOne = preparedStatement.executeQuery();

			while (resultSetOne.next()) {
				oneFilm = getNextFilm(resultSetOne);
			}

			statement.close();
			closeConnection();
		} catch (SQLException se) {
			System.out.println(se);
		}

		return oneFilm;
	}

	public boolean instertFilm(Film film) {
		int filmID = film.getFilmID();
		String filmTitle = film.getFilmTitle();
		int filmYear = film.getFilmYear();
		String filmDirector = film.getFilmDirector();
		String filmCast = film.getFilmCast();
		String filmReview = film.getFilmReview();
		
		boolean success = false;
		
		openConnection();
		try {
			String insertSQL = "INSERT INTO films (id, title, year, director, stars, review) "
					+ "VALUES (?, ?, ?, ?, ?, ?)";

			PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, filmID);
			preparedStatement.setString(2, filmTitle);
			preparedStatement.setInt(3, filmYear);
			preparedStatement.setString(4, filmDirector);
			preparedStatement.setString(5, filmCast);
			preparedStatement.setString(6, filmReview);

			if (preparedStatement.executeUpdate() == 1) {
				System.out.println("Insert Success");
				success = true;
			} else {
				System.out.println("Insert Failed");
				System.out.println(preparedStatement);
			}
			statement.close();
			closeConnection();
		} catch (SQLException se) {
			System.out.println(se);
		}
		
		return success;

	}

	public boolean updateFilm(Film newFilm) {
		int filmID = newFilm.getFilmID();
		String filmTitle = newFilm.getFilmTitle();
		int filmYear = newFilm.getFilmYear();
		String filmDirector = newFilm.getFilmDirector();
		String filmCast = newFilm.getFilmCast();
		String filmReview = newFilm.getFilmReview();
		
		boolean success = false;
		
		openConnection();
		try {
			String insertSQL = "UPDATE films SET title = ?, year = ?, director = ?, stars = ?, review = ? WHERE id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, filmTitle);
			preparedStatement.setInt(2, filmYear);
			preparedStatement.setString(3, filmDirector);
			preparedStatement.setString(4, filmCast);
			preparedStatement.setString(5, filmReview);
			preparedStatement.setInt(6, filmID);
			preparedStatement.executeUpdate();
			if (preparedStatement.executeUpdate() == 1) {
				System.out.println("Update Success");
				success = true;
			} else {
				System.out.println("Update Failed");
				System.out.println(preparedStatement);
			}
			statement.close();
			closeConnection();
		} catch (SQLException se) {
			System.out.println(se);
		}
		
		return success;
	}

	public void deleteFilm(int id) {
		openConnection();
		try {
			String deleteSQL = "DELETE FROM films WHERE id=?";

			PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, id);
			if (preparedStatement.executeUpdate() == 1) {
				System.out.println("Deletion Success");
			} else {
				System.out.println("Deletion Failed");
				System.out.println(preparedStatement);
			}
			System.out.println(preparedStatement.executeUpdate());
			statement.close();
			closeConnection();
		} catch (SQLException se) {
			System.out.println(se);
		}
	}
}
