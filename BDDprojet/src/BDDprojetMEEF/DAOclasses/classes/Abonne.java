package BDDprojetMEEF.DAOclasses.classes;

import java.util.Date;

public class Abonne {


	public int id_client;
	public String nom;
	public String prenom;
	public String adresse;
	public Float montant;
	public Boolean gele; 
	public Date date_naissance;




	
	public Abonne(int id_client, String nom, String prenom, String adresse, Float montant, Boolean gele,
			Date date_naissance) {
		super();
		this.id_client = id_client;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.montant = montant;
		this.gele = gele;
		this.date_naissance = date_naissance;
	}
	
	
	
	public int getId_client() {
		return id_client;
	}
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public Float getMontant() {
		return montant;
	}
	public void setMontant(Float montant) {
		this.montant = montant;
	}


	public Boolean getGele() {
		return gele;
	}
	public void setGele(Boolean gele) {
		this.gele = gele;
	}


	public Date getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}



	
	public void voter(Film film) {
		film.setPopularite(film.getPopularite() + 1);
	}
	
	
	public void ajoutHistorisque(int id_film) {
		//TODO
	}
	
	
	public void crediter(Float montant) {
		this.montant += montant;
	}
	
	public void debiter(Float montant) {
		this.montant = this.montant - montant;
	}

	public void historique() {
		//TODO
	}



	@Override
	public String toString() {
		return "Abonne [nom : " + nom + ", prenom : " + prenom + ", adresse : " + adresse
				 + montant + ", ne le " + date_naissance + ", montant restant : " + montant + "]";
	}

	
	
	
	
	
}