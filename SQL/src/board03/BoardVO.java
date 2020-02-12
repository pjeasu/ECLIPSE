package board03;
//���̺��� �����͸� ��ų� ������� �����͸� ���� Value Object(VO)��ü
//Data Transfer object(DTO) ��� �θ� �� �ִ�.
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

	public void setId(int id) {// �ܺηκ��� �޾ƿ°��� �ʱ�ȭ
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
	
	
	

	// equals�� �ʿ��ϸ� �̰����� ���� ���
}
