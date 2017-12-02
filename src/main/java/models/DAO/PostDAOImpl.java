package models.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.DTO.Category;
import models.DTO.Post;
import models.utils.DBConnection;
import models.utils.SQLiteDBConnection;

public class PostDAOImpl implements PostDAO {
	final String QS_HOMEPAGE = "SELECT p.id, p.name, p.description, p.content, c.id AS [c_id], c.name AS [c_name], c.description AS [c_des]\n"
			+ "FROM post AS p INNER JOIN category AS c\n" + "ON p.category_id = c.id;";

	@Override
	public List<Post> getAllPosts(int limit, int skip) {
		DBConnection dbConnection = new SQLiteDBConnection();
		Connection conn = dbConnection.getConnection();
		List<Post> posts = new ArrayList<>();

		try {
			// Create statement object with connection object.
			Statement stm = conn.createStatement();

			// Execute query string by statement object.
			ResultSet rs = stm.executeQuery(QS_HOMEPAGE);

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
		} finally {
			// For whatever reason happen we must close connection if it opened.
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.err.println(e.getMessage());
				}
			}
		}

		return null;
	}

	@Override
	public Post findPostById(String id) {
		DBConnection dbConnection = new SQLiteDBConnection();
		Connection conn = dbConnection.getConnection();
		final String QS_FIND_POST = "SELECT p.id, p.name, p.description, p.content, c.id AS [c_id], c.name AS [c_name], c.description AS [c_des]\n"
				+ "FROM post AS p INNER JOIN category AS c \n" + "ON p.category_id = c.id\n" + "WHERE p.id = ?;";

		try {
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
		} finally {
			// For whatever reason happen we must close connection if it opened.
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.err.println(e.getMessage());
				}
			}
		}
		return null;
	}

	@Override
	public Post savePost(Post post) {
		return null;
	}

	@Override
	public Post removePost(String id) {
		return null;
	}

	@Override
	public Post updatePost(Post post) {
		DBConnection dbConnection = new SQLiteDBConnection();
		Connection conn = dbConnection.getConnection();
		final String QS_UPDATE_POST = "UPDATE post\n" + "SET name = ?, description = ?, content = ?\n" + "WHERE id = ?";

		try {
			// Create statement object with connection object.
			PreparedStatement stm = conn.prepareStatement(QS_UPDATE_POST);

			// Set post_id via statement.
			stm.setString(1, post.getName());
			stm.setString(2, post.getDescription());
			stm.setString(3, post.getContent());
			stm.setString(4, post.getId());
			
			// Execute update string by statement object.
			if (stm.executeUpdate() != 0) {
				return post;
			}
			
			return null;
		} catch (SQLException e) {
			System.err.println(e.getMessage());

			return null;
		} finally {
			// For whatever reason happen we must close connection if it opened.
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.err.println(e.getMessage());
				}
			}
		}
	}
}
