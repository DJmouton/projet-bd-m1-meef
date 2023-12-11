package BDDprojetMEEF.DAOclasses.classes;

public class Support {

	public int id_support;
	public Boolean bluray;
	public int id_film;



	public Support(int i, Boolean b, int id_film) {
		this.id_support = i;
		this.bluray = b;
		this.id_film = id_film;
	}



	public int getId_support() {
		return this.id_support;
	}
	public void setId_support(int id) {
		this.id_support = id;
	}

	
	public Boolean getBluray() {
		return this.bluray;
	}
	public void setBluray(Boolean b) {
		this.bluray = b;
	}


	public int getId_film() {
		return id_film;
	}
	public void setId_film(int id_film) {
		this.id_film = id_film;
	}



	@Override
	public String toString() {
		return "Support [id_support=" + id_support + ", bluray=" + bluray + "]";
	}


	
	
	
	
}
