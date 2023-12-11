package BDDprojetMEEF.DAOclasses.classes;

public class Film {


	public int id_film;
	public String titre;
	public String realisateur;
	public String acteur_principal;
	public int popularite;
	public String genre;
	public String categorie;
	public boolean qrcode;


	public Film(int p, String t, String r, String a, String g, String c, int id,  boolean qr) {
		this.id_film = id;
		this.titre = t;
		this.realisateur = r;
		this.acteur_principal = a;
		this.popularite = p;
		this.genre = g;
		this.categorie = c;
		this.qrcode = qr;
	}

	
	
	public int getId_film() {
		return id_film;
	}
	public void setId_film(int id_film) {
		this.id_film = id_film;
	}


	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}


	public String getRealisateur() {
		return realisateur;
	}
	public void setRealisateur(String realisateur) {
		this.realisateur = realisateur;
	}


	public String getActeur_principal() {
		return acteur_principal;
	}
	public void setActeur_principal(String acteur_principal) {
		this.acteur_principal = acteur_principal;
	}


	public int getPopularite() {
		return popularite;
	}
	public void setPopularite(int popularite) {
		this.popularite = popularite;
	}
 
	
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}

	
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	
	public boolean isQrcode() {
		return qrcode;
	}
	public void setQrcode(boolean qrcode) {
		this.qrcode = qrcode;
	}


	
	
	
	public void ajoutPopularite() {
		this.popularite += 1;
	}

	public void resetPopularite() {
		this.popularite = 0;
	}


	public boolean disponible() {
		return this.qrcode;
	}



	@Override
	public String toString() {
		return "Film [id_film=" + id_film + ", titre=" + titre + ", realisateur=" + realisateur + ", acteur_principal="
				+ acteur_principal + ", popularite=" + popularite + ", genre=" + genre + ", categorie=" + categorie + "]";
	}


	

}