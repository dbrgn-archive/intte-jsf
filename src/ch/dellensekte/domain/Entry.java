package ch.dellensekte.domain;

import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

public abstract class Entry implements Comparable<Entry> {

	protected List<Comment> comments = new LinkedList<>();
    protected List<Comment> commentsFlat = new LinkedList<>();
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
        this.commentsFlat = new LinkedList<>();
        createFlatList(this.comments, 0);
    }

    public boolean hasComments() {
        return !comments.isEmpty();
    }

    public int getDeepCommentCount() {
        return countComments(comments);
    }

    private int countComments(List<Comment> commentList) {
        int childCount = 0;
        for(Comment comment : commentList)  {

            if(comment.hasComments()) {
                childCount += countComments(comment.getComments());
            }
        }
        return commentList.size() + childCount;
    }

    public List<Comment> getComments() {
        return comments;
    }

    @Override
    public int compareTo(Entry o) {
        return new Integer(o.getRating()).compareTo(this.getRating());
    }

    public List<Comment> getCommentsFlat() {
        this.commentsFlat = new LinkedList<>();
        createFlatList(this.comments, 0);
        return this.commentsFlat;
    }

    protected void createFlatList(List<Comment> commentList, int parentLevel) {
        for(Comment comment : commentList) {
            comment.setLevel(parentLevel + 1);
            commentsFlat.add(comment);
            if(comment.hasComments()) {
                createFlatList(comment.getComments(), parentLevel + 1);
            }
        }
    }

}
