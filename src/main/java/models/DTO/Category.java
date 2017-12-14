package models.DTO;

import java.util.List;

public class Category {
	String id;
	String name;
	String description;
	List<Post> posts;
	
	public Category() {}
	
	public Category(String id) {
		this.id = id;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "[" + this.id + "," + this.name + "," + this.description + "]";
	}
}
