package models.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.DTO.Category;
import models.DTO.Post;
import models.utils.DBConnection;
import models.utils.SQLiteDBConnection;

public class PostDAO {
	final String QS_HOMEPAGE = "SELECT p.id, p.name, p.description, p.content, c.id AS [c_id], c.name AS [c_name], c.description AS [c_des]\n"
			+ "FROM post AS p INNER JOIN category AS c\n" + "ON p.category_id = c.id;";

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
}
