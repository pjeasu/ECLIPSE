package board03;
//테이블의 데이터를 담거나 사용자의 데이터를 담을 Value Object(VO)객체
//Data Transfer object(DTO) 라고도 부를 수 있다.
//

import java.sql.*;

public class BoardVO {
	private int id;
	private String title;
	private String content;
	private Date writtenDate;
	private Date updatedDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {// 외부로부터 받아온값을 초기화
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getWrittenDate() {
		return writtenDate;
	}

	public void setWrittenDate(Date writtenDate) {
		this.writtenDate = writtenDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	public String toString() {
		return id + "\t" + title + "\t" + writtenDate;
	}
	
	
	

	// equals가 필요하면 이곳에서 만들어서 사용
}
