package models.DAO;

import java.util.List;

import exceptions.DAOException;
import models.DTO.Category;

public interface CategoryDAO {
	public List<Category> getAll(int limit, int skip) throws DAOException;
}
