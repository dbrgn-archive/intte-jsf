package ch.dellensekte.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import ch.dellensekte.domain.Comment;
import ch.dellensekte.domain.Post;
import ch.dellensekte.domain.User;

public class DB {

	List<Post> posts = new LinkedList<Post>();
	Map<String, User> users = new HashMap<String, User>();

	public DB() {

		// Create users
		User danilo = new User("danilo", "foo");
		User jonas = new User("jonas", "bar");
		User chrigi = new User("chrigi", "foobar");

		users.put("danilo", danilo);
		users.put("jonas", jonas);
		users.put("chrigi", chrigi);

		// Create posts
		Post p1 = new Post("http://www.google.ch", "G00gle's new website", 10, 1, danilo);
		Post p2 = new Post("http://www.hsr.ch", "HSR Gadgothek", 10, 3, jonas);
		Post p3 = new Post("http://www.namics.ch", "Namics Headbang", 20, 2,jonas);
		Post p4 = new Post("http://www.sbb.ch", "Fahrplanwechsel", 3, 10, chrigi);

		posts.add(p1);
		posts.add(p2);
		posts.add(p3);
		posts.add(p4);

		// Create comments
		Comment c1 = new Comment("Sehr guter Post", 0, 0, danilo);
		Comment c2 = new Comment("Sehr sinnvoller Kommentar", 0, 0, jonas);
		Comment c3 = new Comment("finde ich auch", 0, 0, chrigi);
        Comment c4 = new Comment("deeply nested! nice!", 0, 0, jonas);
        Comment c5 = new Comment("finde ich auch", 0, 0, danilo);

		c1.addComment(c2);
        c1.addComment(c4);
        c1.addComment(c5);
		c2.voteUp();
		c2.addComment(c3);
		p4.addComment(c1);

	}

	public User getUser(String username) {
		return users.get(username);
	}

	public List<Post> getPosts() {
		Collections.sort(posts);
		return posts;
	}

}
