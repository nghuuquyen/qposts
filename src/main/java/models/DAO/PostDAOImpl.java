package models.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import exceptions.DAOException;
import models.DTO.Category;
import models.DTO.Post;
import models.utils.DBConnection;
import models.utils.SQLiteDBConnection;

public class PostDAOImpl implements PostDAO {
	final String QS_GET_ALL_POST = "SELECT p.id, p.name, p.description, p.content, c.id AS [c_id], c.name AS [c_name], c.description AS [c_des]\n"
			+ "FROM post AS p INNER JOIN category AS c\n" + "ON p.category_id = c.id;";

	@Override
	public List<Post> getAllPosts(int limit, int skip) {
		DBConnection dbConnection = new SQLiteDBConnection();
		List<Post> posts = new ArrayList<>();

		try (Connection conn = dbConnection.getConnection()) {
			// Create statement object with connection object.
			Statement stm = conn.createStatement();

			// Execute query string by statement object.
			ResultSet rs = stm.executeQuery(QS_GET_ALL_POST);
			
			// Read result from query and add to return list.
			while (rs.next()) {
				// Create new post object.
				Post p = new Post();
				Category c = new Category();

				// Get data by column name.
				p.setId(rs.getString("id"));
				p.setName(rs.getString("name"));
				p.setDescription(rs.getString("description"));
				p.setContent(rs.getString("content"));
				c.setId(rs.getString("c_id"));
				c.setName(rs.getString("c_name"));
				c.setDescription("c_des");

				// Set category to post object.
				p.setCategory(c);

				// Add post object to return list.
				posts.add(p);
			}

			// Close result set for free memory.
			rs.close();

			return posts;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

		return null;
	}

	@Override
	public Post findPostById(String id) {
		DBConnection dbConnection = new SQLiteDBConnection();
		final String QS_FIND_POST = "SELECT p.id, p.name, p.description, p.content, c.id AS [c_id], c.name AS [c_name], c.description AS [c_des]\n"
				+ "FROM post AS p INNER JOIN category AS c \n" + "ON p.category_id = c.id\n" + "WHERE p.id = ?;";

		try (Connection conn = dbConnection.getConnection()) {
			// Create statement object with connection object.
			PreparedStatement stm = conn.prepareStatement(QS_FIND_POST);

			// Set post_id via statement.
			stm.setString(1, id);

			// Execute query string by statement object.
			ResultSet rs = stm.executeQuery();

			// If result set is empty just return null.
			if (!rs.next())
				return null;

			// Create new post object.
			Post p = new Post();
			Category c = new Category();

			// Get data by column name.
			p.setId(rs.getString("id"));
			p.setName(rs.getString("name"));
			p.setDescription(rs.getString("description"));
			p.setContent(rs.getString("content"));
			c.setId(rs.getString("c_id"));
			c.setName(rs.getString("c_name"));
			c.setDescription("c_des");

			// Set category to post object.
			p.setCategory(c);

			// Close result set for free memory.
			rs.close();
			return p;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

		return null;
	}

	@Override
	public boolean update(Post post) throws DAOException {
		DBConnection dbConnection = new SQLiteDBConnection();
		final String QS_UPDATE_POST = "UPDATE post\n" + "SET name = ?, description = ?, content = ?\n"
				+ "WHERE id = ?;";

		try (Connection conn = dbConnection.getConnection()) {
			PreparedStatement stm = conn.prepareStatement(QS_UPDATE_POST);

			stm.setString(1, post.getName());
			stm.setString(2, post.getDescription());
			stm.setString(3, post.getContent());
			stm.setString(4, post.getId());

			return stm.executeUpdate() != 0;
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public Post create(Post post) throws DAOException {
		DBConnection dbConnection = new SQLiteDBConnection();
		final String QS_CREATE_POST = "INSERT INTO post(id,name,description,content, category_id) \n"
				+ "VALUES (?,?,?,?,?);";

		try (Connection conn = dbConnection.getConnection()) {
			PreparedStatement stm = conn.prepareStatement(QS_CREATE_POST);

			post.setId("P" + (new Date()).getTime());

			stm.setString(1, post.getId());
			stm.setString(2, post.getName());
			stm.setString(3, post.getDescription());
			stm.setString(4, post.getContent());
			stm.setString(5, post.getCategory().getId());

			// Return new created post if execute success.
			return stm.executeUpdate() != 0 ? post : null;
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public boolean remove(String id) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}
}
