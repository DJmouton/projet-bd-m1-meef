package BDDprojetMEEF.DAOclasses.classes;

public class Client{

	
	public int id_client;
	public int cb;
	
	
	
	public Client(int id, int c) {
		this.id_client = id;
		this.cb = c;
	}



	public int getId_client() {
		return id_client;
	}
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}


	public int getCb() {
		return cb;
	}
	public void setCb(int cb) {
		this.cb = cb;
	}
	
	
	
	
	public void facturation(int id_film) {
		//TODO
	}



	@Override
	public String toString() {
		return "Client [id = " + id_client + ", cb = " + cb + "]";
	}
	
	
	
	
}
