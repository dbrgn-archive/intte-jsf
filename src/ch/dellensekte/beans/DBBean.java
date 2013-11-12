package ch.dellensekte.beans;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import ch.dellensekte.domain.Post;
import ch.dellensekte.domain.User;
import ch.dellensekte.util.DB;

@ManagedBean(eager = true)
@ApplicationScoped
public class DBBean {
	final DB db = new DB();

	public DBBean() {

	}

	public List<Post> getPosts() {
		return db.getPosts();
	}

	public User getUser(String username) {
		return db.getUser(username);
	}

	public boolean userExists(String username) {
		return db.users.get(username) != null;
	}

    public void addPost(Post post) {
        db.addPost(post);
    }
}
