package BDDprojetMEEF.DAOclasses;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BDDprojetMEEF.DAOclasses.classes.Client;

public abstract class ClientDAO extends DAO<Client> {

	public ClientDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void create(Client obj) {
		Client client = (Client) obj;
		PreparedStatement ps = null;
		
		try {
			String sql = "INSERT INTO client(id_client, cb) VALUES(?, ?)";
			ps = this.conn.prepareStatement(sql);
			ps.setInt(1, client.id_client);
			ps.setInt(2, client.cb);
			ps.execute();
			System.out.println("Data insered");
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}


	public Client read(int id) {
		Client client = new Client(id, 0);
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM client WHERE id_client = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			client.cb = rs.getInt("cb");
			
			System.out.println(client.toString());

			
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
		return client;
	}
	
	public List<Client> readAll(){
		List<Client> clients = new ArrayList<Client>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM client ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Client c = new Client(rs.getInt("id_client"), rs.getInt("cb"));
				clients.add(c);
				System.out.println(c.toString());
			}

		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
		return clients;
	}
	

	public void update(Client obj) {
		Client client = (Client) obj;
		PreparedStatement ps = null;
		
		try {
			String sql = "UPDATE client set cb = ? WHERE  id_client = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, client.cb);
			ps.setInt(2, client.id_client);
			ps.execute();
			
			System.out.println("Data update");
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
	public void updateAll(List<Client> obj) {
		List<Client> clients = (List<Client>) obj;
		PreparedStatement ps = null;
		
		try {
			for (Client client : clients) {
				String sql = "UPDATE client set cb = ? WHERE  id_client = ? ";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, client.cb);
				ps.setInt(2, client.id_client);
				ps.execute();				
			}
			
			System.out.println("Data update");
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}


	public void delete(Client obj) {
		Client client = (Client) obj;
		PreparedStatement ps = null;
		
		try {
			String sql = "DELETE FROM client WHERE id_film = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, client.id_client);
			ps.execute();
			System.out.println("Data delete");
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
	
}
