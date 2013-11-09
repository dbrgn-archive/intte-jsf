package ch.dellensekte.domain;

public class Comment extends Entry{
	private String comment;
    private int level;

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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
