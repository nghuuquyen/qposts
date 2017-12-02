package models.DAO;

import java.util.List;

import models.DTO.Post;

public interface PostDAO {
	public Post findPostById(String id);
	public List<Post> getAllPosts(int limit, int skip);
	public Post savePost(Post post);
	public Post removePost(String id);
	public Post updatePost(Post post);
}
