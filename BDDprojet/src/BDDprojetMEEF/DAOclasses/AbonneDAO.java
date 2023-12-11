package BDDprojetMEEF.DAOclasses;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BDDprojetMEEF.DAOclasses.classes.Abonne;

public class AbonneDAO extends DAO<Abonne> {

	public AbonneDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void create(Abonne obj) {
		Abonne abonne = (Abonne) obj;
		PreparedStatement ps = null;
		
		try {
			String sql = "INSERT INTO abonne(id_client, nom, prenom, date_naissance, adresse, monant, gele) VALUES(?, ?, ?, ?, ? ,?, ?)";
			ps = this.conn.prepareStatement(sql);
			ps.setInt(1, abonne.id_client);
			ps.setString(2, abonne.nom);
			ps.setString(3, abonne.prenom);
			ps.setDate(4, (Date) abonne.date_naissance);
			ps.setString(5, abonne.adresse);
			ps.setFloat(6, abonne.montant);
			ps.setBoolean(7, abonne.gele);
			ps.execute();
			System.out.println("Data insered");
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}

	/**
	 * selectionne l'abonnement du client donné via son id
	 * @param id
	 */
	public Abonne read(int id) {
		Abonne abonne = new Abonne(id, null, null, null, null, null, null);
		
		PreparedStatement ps = null;
		ResultSet rs = null;		
		try {
			String sql = "SELECT * FROM abonne WHERE id_client = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			abonne.nom = rs.getString("nom");
			abonne.prenom = rs.getString("prenom");
			abonne.date_naissance = rs.getDate("date_naissance");
			abonne.adresse = rs.getString("adresse");
			abonne.montant = rs.getFloat("montant");
			abonne.gele = rs.getBoolean("gele");
			
			System.out.println(abonne.toString());
			
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
		return abonne;
	}
	
	
	/**
	 * selectionne tout les clients
	 */
	public List<Abonne> readAll() {
		List<Abonne> abonnes = new ArrayList<Abonne>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;		
		try {
			String sql = "SELECT * FROM abonne ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Abonne abonne = new Abonne(0, null, null, null, null, null, null);
				abonne.nom = rs.getString("nom");
				abonne.prenom = rs.getString("prenom");
				abonne.date_naissance = rs.getDate("date_naissance");
				abonne.adresse = rs.getString("adresse");
				abonne.montant = rs.getFloat("montant");
				abonne.gele = rs.getBoolean("gele");
				
				abonnes.add(abonne);
				System.out.println(abonne.toString());
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
		return abonnes;
	}
	
	
	
	
	

	public void update(Abonne obj) {
		Abonne abonne = (Abonne) obj;
		PreparedStatement ps = null;
		
		try {
			String sql = "UPDATE abonne set nom = ?, prenom = ?, date_naissance = ?, addresse = ?, montant = ?, gele = ? WHERE  id_client = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, abonne.nom);
			ps.setString(2, abonne.prenom);
			ps.setDate(3, (Date) abonne.date_naissance);
			ps.setString(4, abonne.adresse);
			ps.setFloat(5, abonne.montant);
			ps.setBoolean(6, abonne.gele);
			ps.setInt(7, abonne.id_client);
			ps.execute();
			
			System.out.println("Data update");
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}	

	public void updateAll(List<Abonne> obj) {
		List<Abonne> abonnes = (List<Abonne>) obj;
		PreparedStatement ps = null;
		
		try {
			for (Abonne abonne : abonnes) {
				String sql = "UPDATE abonne set nom = ?, prenom = ?, date_naissance = ?, addresse = ?, montant = ?, gele = ? WHERE  id_client = ? ";
				ps = conn.prepareStatement(sql);
				ps.setString(1, abonne.nom);
				ps.setString(2, abonne.prenom);
				ps.setDate(3, (Date) abonne.date_naissance);
				ps.setString(4, abonne.adresse);
				ps.setFloat(5, abonne.montant);
				ps.setBoolean(6, abonne.gele);
				ps.setInt(7, abonne.id_client);
				ps.execute();
				
			}
			
			System.out.println("Data update");
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
	
	
	


	public void delete(Abonne obj) {
		Abonne abonne = (Abonne) obj;
		PreparedStatement ps = null;
		
		try {
			String sql = "DELETE FROM abonne WHERE id_client = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, abonne.id_client);
			ps.execute();
			System.out.println("Data delete");
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}


}
