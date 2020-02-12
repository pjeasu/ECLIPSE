package comic;

public class InfoVO {
	private int id;
	private int writerId;
	private String title;
	private String genre;
	private String week;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWriterId() {
		return writerId;
	}

	public void setWriterId(int writerId) {
		this.writerId = writerId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	@Override
	public String toString() {
		// return id + "\t" + title + "\t" + genre + "\t" + week ;
		return (String.format("%-8s%-15s%10s%10s", id, title, genre, week));
	}

}
