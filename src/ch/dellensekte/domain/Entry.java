package ch.dellensekte.domain;

import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

public abstract class Entry implements Comparable<Entry> {

	protected List<Comment> comments = new LinkedList<Comment>();
	protected int upVotes;
	protected int downVotes;
	protected GregorianCalendar timestamp;
	protected User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Entry(int upVotes, int downVotes, User user) {
		super();
		this.upVotes = upVotes;
		this.downVotes = downVotes;
		this.user = user;
		this.timestamp = new GregorianCalendar();
	}

	public GregorianCalendar getTimestamp() {
		return this.timestamp;
	}

	public int getVoteCount() {
		return this.upVotes + this.downVotes;
	}

	public void voteUp() {
        ++this.upVotes;
    }

	public void voteDown() {
		++this.downVotes;
	}

	public int getRating() {
		//return this.upVotes / (this.upVotes + this.downVotes);
        return this.upVotes - this.downVotes;
	}

	public Duration getDurationSinceCreated() {
		long now = new GregorianCalendar().getTimeInMillis();
		long secondsAgo = (now - timestamp.getTimeInMillis()) / 1000;

		if (secondsAgo < 60)
			return new Duration(TimeUnit.SECONDS, secondsAgo);
		if (secondsAgo < 60 * 60)
			return new Duration(TimeUnit.MINUTES, secondsAgo / 60);
		if (secondsAgo < 60 * 60 * 24)
			return new Duration(TimeUnit.HOURS, secondsAgo / 60 / 60);
		return new Duration(TimeUnit.DAYS, secondsAgo / 86400);
	}

	public void addComment(Comment c) {
		this.comments.add(c);
	}

    public int getCommentCount() {
        return comments.size();
    }

    @Override
    public int compareTo(Entry o) {
        return new Integer(this.getRating()).compareTo(new Integer(this.getRating()));
    }
}
