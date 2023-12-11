package BDDprojetMEEF.DAOclasses.classes;

import java.util.Date;

public class Location {

	
	public Date dateLocation;
	public String support;
	public int id_film;
	public int id_client;
	
	
	public Location(Date dateLocation, String support, int id_film, int id_client) {
		this.dateLocation = dateLocation;
		this.support = support;
		this.id_film = id_film;
		this.id_client = id_client;
	}


	public Date getDateLocation() {
		return dateLocation;
	}
	public void setDateLocation(Date dateLocation) {
		this.dateLocation = dateLocation;
	}


	public String getSupport() {
		return support;
	}
	public void setSupport(String support) {
		this.support = support;
	}
	
	
	public int getId_film() {
		return id_film;
	}
	public void setId_film(int id_film) {
		this.id_film = id_film;
	}


	public int getId_client() {
		return id_client;
	}
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}


	
	
	public void locationFilm(int idFilm) {
		//TODO 
	}


	@Override
	public String toString() {
		return "Location [date : " + dateLocation + ", support choisie : " + support + ", film : " + id_film 
				+ ", client : " + id_client + "]";
	}
	
	
	
	
	
}
