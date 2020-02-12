package edu.bit.dto;

import java.util.Random;

public class Dto {
//	private String empno;
	private String ename;
	private String sal;
//	private String job;
//	private String mgr;
//	private String hiredate;

//	private String comm;
//	private String deptno;
	
	public Dto() {}

	public Dto(String ename, String sal) {
		super();
		this.ename = ename;
		this.sal = sal;
		
	}


	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getSal() {
		return sal;
	}

	public void setSal(String sal) {
		this.sal = sal;
	}

//	public String getPhoto() {
//		Random random = new Random();
//		int num = random.nextInt(6)+1;
//		return "product" + String.valueOf(num) + ".jpg";
//		
//	}
	
}
