package ch.dellensekte.beans;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import ch.dellensekte.domain.Post;
import ch.dellensekte.util.DB;

@ManagedBean
@ApplicationScoped
public class PostsBean {
	DB db = new DB();

	public List<Post> getPosts() {
		return db.getPosts();
	}
	
	public void setPosts(){
		
	}

}
