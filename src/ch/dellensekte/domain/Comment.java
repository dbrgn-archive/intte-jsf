package ch.dellensekte.domain;

public class Comment extends Entry{
	private String comment;
	private User user;

	public Comment(String comment, int upVotes, int downVotes, User user) {
		super(upVotes, downVotes, user);
		this.comment=comment;
	}


	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public int compareTo(Entry o) {
		return this.getTimestamp().compareTo(o.getTimestamp());
	}
	


}
