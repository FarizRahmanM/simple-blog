package com.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blog.repository.PostRepository;
import com.blog.vo.Post;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getPosts() {
        List<Post> postList = postRepository.findPost();
        return postList;
    }
    
    public List<Post> searchPostByTitle(String query) {
    	List<Post> posts = postRepository.findPostLikeTitle(query);
    	return posts;
    }
    
    public boolean savePost (Post post) {
    	int result = postRepository.savePost(post);
    	boolean isSuccess = true;
    	
    	if (result == 0) {
    		isSuccess = false;
    	}
    	
    	return isSuccess;
    }
    
}
