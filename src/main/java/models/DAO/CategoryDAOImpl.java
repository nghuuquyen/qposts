package models.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exceptions.DAOException;
import models.DTO.Category;
import models.utils.DBConnection;
import models.utils.MySQLDBConnection;

public class CategoryDAOImpl implements CategoryDAO {

	@Override
	public List<Category> getAll(int limit, int skip) throws DAOException {
		DBConnection dbConnection = new MySQLDBConnection();
		List<Category> categories = new ArrayList<>();

		try (Connection conn = dbConnection.getConnection()) {
			// Create statement object with connection object.
			Statement stm = conn.createStatement();

			// Execute query string by statement object.
			ResultSet rs = stm.executeQuery("SELECT * FROM category;");

			// Read result from query and add to return list.
			while (rs.next()) {
				// Create new post object.
				Category c = new Category();

				c.setId(rs.getString("id"));
				c.setName(rs.getString("name"));
				c.setDescription(rs.getString("description"));

				// Add category object to return list.
				categories.add(c);
			}

			// Close result set for free memory.
			rs.close();

			return categories;
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
	}

}
