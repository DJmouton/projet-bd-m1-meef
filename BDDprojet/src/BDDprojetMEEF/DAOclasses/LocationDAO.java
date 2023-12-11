package BDDprojetMEEF.DAOclasses;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BDDprojetMEEF.DAOclasses.classes.Location;

public class LocationDAO extends DAO<Location> {

	public LocationDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void create(Location obj) {
		Location location = (Location) obj;
		PreparedStatement ps = null;
		
		try {
			String sql = "INSERT INTO locations(id_client, id_film, support, date_location) VALUES(?, ?, ?, ?)";
			ps = this.conn.prepareStatement(sql);
			ps.setInt(1, location.id_client);
			ps.setInt(2, location.id_film);
			ps.setString(3, location.support);
			ps.setDate(4, (Date) location.dateLocation);
			ps.execute();
			System.out.println("Data insered");
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}

	
	
	/**
	 * selectionne toute les location pour un client donnée via son id
	 * @param id_client
	 * @return
	 */
	public List<Location> readAllForC(int id_client) {
		List<Location> locations = new ArrayList<Location>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		try {
			String sql = "SELECT * FROM locations WHERE id_client = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id_client);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Location location = new Location(null, null, 0, id_client);
				location.id_client = id_client;
				location.id_film = rs.getInt("id_film");
				location.support = rs.getString("support");
				location.dateLocation = rs.getDate("date_location");
				
				System.out.println(location.toString());
				locations.add(location);
			}
			
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
		return locations;
	}

	/**
	 * selectionne toute les location pour un film donnée via son id
	 * @param id_client
	 * @return
	 */
	public List<Location> readAllForF(int id_film) {
		List<Location> locations = new ArrayList<Location>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		try {
			String sql = "SELECT * FROM locations WHERE id_film = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id_film);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Location location = new Location(null, null, id_film, 0);
				location.id_client = rs.getInt("id_client");
				location.id_film = id_film;
				location.support = rs.getString("support");
				location.dateLocation = rs.getDate("date_location");
				
				System.out.println(location.toString());
				locations.add(location);
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
		return locations;
	}
	
	/**
	 * selectionne la location pour 1 film et 1 client donné
	 * @param id_film
	 * @param id_client
	 */
	public Location read(int id_film, int id_client) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Location location = new Location(null, null, id_film, id_client);
		
		try {
			String sql = "SELECT * FROM locations WHERE id_client = ? and id_film = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id_client);
			ps.setInt(2, id_film);
			rs = ps.executeQuery();
			
			location.id_client = id_client;
			location.id_film = id_film;
			location.support = rs.getString("support");
			location.dateLocation = rs.getDate("date_location");
			
			System.out.println(location.toString());

			
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
		return location;
	}
	
	
	
	/**
	 * update 
	 * @param obj
	 */
	public void update(Location obj) {
		Location location = (Location) obj;
		PreparedStatement ps = null;
		
		try {
			String sql = "UPDATE locations set support = ?, date_location = ? WHERE  id_client = ? and id_film = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, location.support);
			ps.setDate(2, (Date) location.dateLocation);
			ps.setInt(3, location.id_client);
			ps.setInt(4, location.id_film);
			ps.execute();
			
			System.out.println("Data update");
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}	
	
	/**
	 * update all in list
	 * @param obj
	 */
	public void updateAll(List<Location> obj) {
		List<Location> locations = (List<Location>) obj;
		PreparedStatement ps = null;
		
		try {
			for (Location location : locations) {
				String sql = "UPDATE locations set support = ?, date_location = ? WHERE  id_client = ? and id_film = ? ";
				ps = conn.prepareStatement(sql);
				ps.setString(1, location.support);
				ps.setDate(2, (Date) location.dateLocation);
				ps.setInt(3, location.id_client);
				ps.setInt(4, location.id_film);
				ps.execute();				
			}
			
			System.out.println("Data update");
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}

	
	
	
	/**
	 * delete  
	 * @param obj
	 */
	public void delete(Location obj) {
		Location location = (Location) obj;
		PreparedStatement ps = null;
		
		try {
			String sql = "DELETE FROM locations WHERE  id_client = ? and id_film = ? and date_location = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, location.id_client);
			ps.setInt(2, location.id_film);
			ps.setDate(3, (Date) location.dateLocation);
			ps.execute();
			System.out.println("Data delete");
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}

}