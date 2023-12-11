package BDDprojetMEEF.DAOclasses.classes;

import java.util.ArrayList;
import java.util.List;

public class AL2000 {


	public int id_robot;
	
	public List<Film> liste_Film;
	public List<Client> liste_Client;




	public AL2000(int id) {
		this.id_robot = id;
	}


	public void resetMensuelVote() {
		for (Film f : liste_Film) {
			f.popularite = 0;
		}
	}


	public List<Film> listeFilm(boolean disponiste) {
		List<Film> retour = new ArrayList<Film>();
		for (Film film : liste_Film) {
			if (film.disponible()) {
				retour.add(film);
			}
		}
		return retour;
		
	}
	
	public boolean deliverFilm(int id_film, Support support) {
		return liste_Film.get(id_film).disponible();
	}


	public void facturation(String id_film, int id_client) {
		
	}


	public void updateMensuel(Support support, String id_film, 
								int nb_update, boolean disponible) {

	}
	
	
	public void afficherHistorique(List<Film> liste_Film) {

	}



	public void restituerFilm(int id_film, int id_client) {

	}
	public void locationFilm(int id_film, int id_client) {

	}


	public void verifierQRCodes() {

	}


	@Override
	public String toString() {
		String retour = "AL2000 [id_robot=" + id_robot + "]\n liste film : \n";
		for (Film film : liste_Film) {
			retour += film.toString() + "\n";
		}
		retour += "\n liste client :\n";
		for (Client client : liste_Client) {
			retour += client.toString() + "\n";
		}
		return retour;
	}














}