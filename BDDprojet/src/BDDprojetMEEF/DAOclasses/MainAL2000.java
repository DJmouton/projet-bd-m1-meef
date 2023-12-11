package BDDprojetMEEF.DAOclasses;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import BDDprojetMEEF.DAOclasses.classes.Film;

public class MainAL2000 {

	public static void main(String[] args) {

		Film film = new Film(865, "bonjour je test", "Moi", "toi", "horreur", "+18", 765, false);

		FilmDAO filmDao = new FilmDAO();
		//filmDao.create(film);
		
		
		resetMensuelVote();

	}
	
	
	
	public static void resetMensuelVote() {
		Connection conn = FilmDAO.connect();
		FilmDAO filmDao = new FilmDAO();
		List<Film> films = new ArrayList<Film>();
		films = filmDao.readAll();
	
		filmDao.updateAll(films);
	}
	
	
	public static List<Film> listFilm(Boolean disponible) {
		Connection conn = FilmDAO.connect();
		FilmDAO filmDao = new FilmDAO();
		List<Film> films = new ArrayList<Film>();
		
		
		
		return films;
	}
	
	
	
	public static void delivrerFilm(int id_film) {
		Connection conn = LocationDAO.connect();
		
		
	}
	

}









