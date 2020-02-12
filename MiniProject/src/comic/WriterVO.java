package comic;



public class WriterVO {
	private int id;
	private String writer;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String toString() {
		//return id + "\t" + writer + "\t";
		return (String.format("%3s%8s%-14s", id," ", writer));
	}
}
