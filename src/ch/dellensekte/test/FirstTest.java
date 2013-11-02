package ch.dellensekte.test;

import java.util.List;

import org.junit.Test;

import ch.dellensekte.domain.Post;
import ch.dellensekte.util.DB;

public class FirstTest {

	@Test
	public void printPosts() {
		DB db = new DB();
		List<Post> posts = db.getPosts();
		for (Post p : posts) {
			System.out.println(p);
		}
	}
}
