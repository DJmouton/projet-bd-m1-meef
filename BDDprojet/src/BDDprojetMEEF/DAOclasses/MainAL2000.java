package BDDprojetMEEF.DAOclasses;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import BDDprojetMEEF.DAOclasses.classes.Abonne;
import BDDprojetMEEF.DAOclasses.classes.Client;
import BDDprojetMEEF.DAOclasses.classes.Film;
import BDDprojetMEEF.DAOclasses.classes.Location;
import BDDprojetMEEF.DAOclasses.classes.Support;

public class MainAL2000 {

	public static void main(String[] args) {

		//Film film = new Film(865, "bonjour je test", "Moi", "toi", "horreur", "+18", 765, false);

		//FilmDAO filmDao = new FilmDAO();
		//filmDao.create(film);
		//resetMensuelVote();
		//facturation(1, 8, 1);
		//afficherHistoriqueFilm(3);
		//restitutionFilm(4, 4);
		//locationFilm(2, 13);
		//verifierQrCode(3);
		
		
		//ajoutPopularite(2);
		//resetPopularite(2);
		
		//voter(2);
		//crediter(5, 50);
		//historique(5);
		
	}
	
	// FONCTIONS AL2000
	
	public static void resetMensuelVote() {
		FilmDAO filmDao = new FilmDAO();
		List<Film> films = new ArrayList<Film>();
		films = filmDao.readAll();
	
		filmDao.updateAll(films);
	}

	public static void delivrerFilm(Film f) {		
		FilmDAO filmDAO = new FilmDAO();
		filmDAO.create(f);
		
		Support support = new Support((int) Math.random()*1000, false, f.id_film);
		SupportDAO supoDao = new SupportDAO();
		supoDao.create(support);
	}
	
	public static void facturation(int id_film, int id_client, int nbJour) {
		ClientDAO clientDAO = new ClientDAO();
		clientDAO.connect();
		Client client = clientDAO.read(id_client);
		AbonneDAO abonneDAO = new AbonneDAO();
		
		Abonne abonne = abonneDAO.read(id_client);
		if (abonne == null) {
			client.cb -= 5 * nbJour;
		}
		else {
			client.cb -= 4 * nbJour;
		}
		clientDAO.update(client);
		
	}

	public static void afficherHistoriqueFilm(int id_film) {
		LocationDAO locationDAO = new LocationDAO();
		List<Location> locations = locationDAO.readAllForF(id_film);
	}
	
	public static void restitutionFilm(int id_film, int id_client) {
		LocationDAO locationDAO = new LocationDAO();
		Location location = locationDAO.read(id_film, id_client);

		facturation(id_film, id_client, (int) (System.currentTimeMillis()- location.dateLocation.getTime()));
		
	}
	
	public static void locationFilm(int id_film, int id_client) {

		LocationDAO locationDAO = new LocationDAO();
		Location location = new Location(new Date(System.currentTimeMillis()), "blu-ray", id_film, id_client);
		locationDAO.create(location);
		
		facturation(id_film, id_client, 1);
		
	}
	
	public static void verifierQrCode(int id_film) {
		FilmDAO filmDAO = new FilmDAO();
		Boolean qrcodeDispo = filmDAO.readQrCode(id_film);
	}
	
	//FONCTIONS FILM
	
	public static void ajoutPopularite(int id_film) {
		FilmDAO filmDAO = new FilmDAO();
		Film film = filmDAO.read(id_film);
		film.popularite++;
		filmDAO.update(film);
	}
	
	public static void resetPopularite(int id_film) {
		FilmDAO filmDAO = new FilmDAO();
		Film film = filmDAO.read(id_film);
		film.popularite = 0;
		filmDAO.update(film);
	}
	

	
	// FONCTIONS ABONNE
	
	public static void voter(int id_film) {
		ajoutPopularite(id_film);
	}
	
	public static void crediter(int id_client, int montant) {
		AbonneDAO abonneDAO = new AbonneDAO();
		Abonne abonne = abonneDAO.read(id_client);
		abonne.montant += montant;
		abonneDAO.update(abonne);
	}
	
	public static void historique(int id_client) {
		LocationDAO locationDAO = new LocationDAO();
		List<Location> locations = locationDAO.readAllForC(id_client);
		FilmDAO filmDAO = new FilmDAO();
		
		for (Location location : locations) {
			filmDAO.read(location.id_film);
		}
	}
	
}









