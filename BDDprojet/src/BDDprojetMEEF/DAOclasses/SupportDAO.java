package BDDprojetMEEF.DAOclasses;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BDDprojetMEEF.DAOclasses.classes.Support;

public class SupportDAO extends DAO<Support> {

	public SupportDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void create(Support obj) {
		Support support = (Support) obj;
		PreparedStatement ps = null;
		
		try {
			String sql = "INSERT INTO support(id_support, bluray, id_film VALUES(?, ?, ?)";
			ps = this.conn.prepareStatement(sql);
			ps.setInt(1, support.id_support);
			ps.setBoolean(2, support.bluray);
			ps.setInt(3, support.id_film);
			ps.execute();
			System.out.println("Data insered");
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}

	
	
	/**
	 * selectionne le support via son id
	 * @param id
	 */
	public Support read(int id_support) {
		Support support = new Support(id_support, null, 0);
		
		PreparedStatement ps = null;
		ResultSet rs = null;		
		try {
			String sql = "SELECT * FROM support WHERE id_support = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id_support);
			rs = ps.executeQuery();

			support.bluray = rs.getBoolean("bluray");
			support.id_film = rs.getInt("id_film");
			
			System.out.println(support.toString());
			
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
		return support;
	}

	/**
	 * selectionne les supports correspondant à l'id du film
	 * @param id
	 */
	public Support readByFilm(int id_film) {
		Support support = new Support(0, null, id_film);
		
		PreparedStatement ps = null;
		ResultSet rs = null;		
		try {
			String sql = "SELECT * FROM support WHERE id_film = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id_film);
			rs = ps.executeQuery();

			support.id_support = rs.getInt("id_support");
			support.bluray = rs.getBoolean("bluray");
			
			System.out.println(support.toString());
			
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
		return support;
	}

	/**
	 * selectionne les supports correspondant à l'id du film
	 * @param id
	 */
	public List<Support> readAll() {
		List<Support> supports = new ArrayList<Support>();
		
		
		PreparedStatement ps = null;
		ResultSet rs = null;		
		try {
			String sql = "SELECT * FROM support ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Support support = new Support(0, null, 0);
				support.id_support = rs.getInt("id_support");
				support.bluray = rs.getBoolean("bluray");
				support.id_film  =rs.getInt("id_film");
				
				supports.add(support);
				System.out.println(support.toString());
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
		return supports;
	}

	
	

	
	/**
	 * update
	 * @param obj
	 */
	public void update(Support obj) {
		Support support = (Support) obj;
		PreparedStatement ps = null;
		
		try {
			String sql = "UPDATE support set bluray = ?, id_film = ? WHERE  id_support = ? ";
			ps = conn.prepareStatement(sql);
			ps.setBoolean(1, support.bluray);
			ps.setInt(2, support.id_film);
			ps.execute();
			
			System.out.println("Data update");
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
	
	/**
	 * update all
	 * @param obj
	 */
	public void updateAll(List<Support> obj) {
		List<Support> supports = (List<Support>) obj;
		PreparedStatement ps = null;
		
		try {
			for (Support support : supports) {
				String sql = "UPDATE support set bluray = ?, id_film = ? WHERE  id_support = ? ";
				ps = conn.prepareStatement(sql);
				ps.setBoolean(1, support.bluray);
				ps.setInt(2, support.id_film);
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
	public void delete(Support obj) {
		Support support = (Support) obj;
		PreparedStatement ps = null;
		
		try {
			String sql = "DELETE FROM support WHERE id_support = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, support.id_support);
			ps.execute();
			System.out.println("Data delete");
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}


}