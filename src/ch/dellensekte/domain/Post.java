package ch.dellensekte.domain;

public class Post extends Entry {

	private String url;
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Post(String url, String title, int upVotes, int downVotes, User user) {
		super(upVotes, downVotes, user);
		this.url = url;
		this.title = title;
	}

	@Override
	public int compareTo(Entry o) {
		return new Integer(this.getRating()).compareTo(new Integer(this.getRating()));
	}

	@Override
	public String toString() {
		return this.title + " " + this.url + " created by "
				+ this.user.getUsername() + " "
				+ this.getDurationSinceCreated().getValue() + " "
				+ this.getDurationSinceCreated().getUnit() + " ago";
	}

}
