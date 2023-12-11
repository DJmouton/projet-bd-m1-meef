package BDDprojetMEEF.DAOclasses;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BDDprojetMEEF.DAOclasses.classes.Film;

public class FilmDAO extends DAO<Film> {

	public FilmDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void create(Film obj) {
		Film film = (Film) obj;
		PreparedStatement ps = null;
		
		try {
			String sql = "INSERT INTO film(id_film, titre, realisateur, acteur_principal, popularite, genre, categorie, qr_code) "
								+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			ps = this.conn.prepareStatement(sql);
			ps.setInt(1, film.id_film);
			ps.setString(2, film.titre);
			ps.setString(3, film.realisateur);
			ps.setString(4, film.acteur_principal);
			ps.setInt(5, film.popularite);
			ps.setString(6, film.genre);
			ps.setString(7, film.categorie);
			ps.setBoolean(8, film.qrcode);
			ps.execute();
			System.out.println("Data insered");
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}

	/**
	 * selectionne le film via son id
	 * @param id
	 */
	public Film read(int id) {
		Film film = new Film(0, null, null, null, null, null, 0, false);
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM film WHERE id_film = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			film.id_film = id;
			film.titre = rs.getString("titre");
			film.realisateur = rs.getString("realisateur");
			film.acteur_principal = rs.getString("acteur_principal");
			film.popularite = rs.getInt("popularite");
			film.genre = rs.getString("genre");
			film.categorie = rs.getString("categorie");
			film.qrcode = rs.getBoolean("qr_code");
			
			System.out.println(film.toString());

			
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
		return film;
	}
	
	/**
	 * selectionne tous les films
	 */
	public List<Film> readAll() {
		List<Film> films = new ArrayList<Film>();
		PreparedStatement ps = null;
		ResultSet rs = null;

		
		try {
			String sql = "SELECT * FROM FILM ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Film film = new Film(0, null, null, null, null, null, 0, false);
				film.id_film = rs.getInt("id_film");
				film.titre = rs.getString("titre");
				film.realisateur = rs.getString("realisateur");
				film.acteur_principal = rs.getString("acteur_principal");
				film.popularite = rs.getInt("popularite");
				film.genre = rs.getString("genre");
				film.categorie = rs.getString("categorie");
				film.qrcode = rs.getBoolean("qr_code");
				
				System.out.println(film.toString());
				films.add(film);
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
		return films;
	}
	
	
	public Boolean readQrCode(int id_film) {
		Boolean bool = false;
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT film.qr_code FROM film WHERE id_film = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id_film);
			rs = ps.executeQuery();
			
			bool = rs.getBoolean("qr_code");
			
			System.out.println(bool);

			
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
		return bool;
	}
	
	
	public void update(Film obj) {
		Film film = (Film) obj;
		PreparedStatement ps = null;
		
		try {
			String sql = "UPDATE film set titre = ?, realisateur = ?, acteur_principal = ?, popularite = ?, "
					+ "genre = ?, categorie = ?, qr_code = ? WHERE  id_film = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, film.titre);
			ps.setString(2, film.realisateur);
			ps.setString(3, film.acteur_principal);
			ps.setInt(4, film.popularite);
			ps.setString(5, film.genre);
			ps.setString(6, film.categorie);
			ps.setBoolean(7, film.qrcode);
			ps.setInt(8, film.id_film);
			ps.execute();
			
			System.out.println("Data update");
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
	
	
	public void updateAll(List<Film> obj) {
		List<Film> films = (List<Film>) obj;
		PreparedStatement ps = null;
		
		try {
			for (Film film : films) {
				String sql = "UPDATE film set titre = ?, realisateur = ?, acteur_principal = ?, popularite = ?, "
						+ "genre = ?, categorie = ?, qr_code = ? WHERE  id_film = ? ";
				ps = conn.prepareStatement(sql);
				ps.setString(1, film.titre);
				ps.setString(2, film.realisateur);
				ps.setString(3, film.acteur_principal);
				ps.setInt(4, film.popularite);
				ps.setString(5, film.genre);
				ps.setString(6, film.categorie);
				ps.setBoolean(7, film.qrcode);
				ps.setInt(8, film.id_film);
				ps.execute();
			}
			
			System.out.println("Data update");
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
	
	


	public void delete(Film obj) {
		Film film = (Film) obj;
		PreparedStatement ps = null;
		
		try {
			String sql = "DELETE FROM film WHERE id_film = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, film.id_film);
			ps.execute();
			System.out.println("Data delete");
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
}
