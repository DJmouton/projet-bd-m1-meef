package BDDprojetMEEF.DAOclasses.classes;

public class Prix_Location {


	public String categorie;
	public Float prix;


	public Prix_Location(String c, Float p) {
		this.categorie = c;
		this.prix = p;
	}



	public String getCategorie() {
		return this.categorie;
	}
	public void setCategorie(String c) {
		this.categorie = c;
	}

	
	public Float getPrix() {
		return this.prix;
	}
	public void setPrix (float p) {
		this.prix = p;
	}



	@Override
	public String toString() {
		return "Prix de la location [prix : " + prix + ", categorie : " + categorie + "]";
	}

	
	
	
	
}
