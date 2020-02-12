package edu.bit.hw;

//요즘은 MemberVO라고 많이 씀
public class DTO {
	//변수명과 컬럼명은 맞추는게 좋다
	private String empno;
	private String ename;
	private String job;
	private String mgr;
	private String hiredate;
	private String sal;
	private String comm;
	private String deptno;
	
	
	//디폴트생성자 만들어놓기
	public DTO() {}


	public DTO(String empno, String ename, String job, String mgr, String hiredate, String sal, String comm, String deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}


	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public String getEmpno() {
		return empno;
	}


	public void setEmpno(String empno) {
		this.empno = empno;
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}


	public String getMgr() {
		return mgr;
	}


	public void setMgr(String mgr) {
		this.mgr = mgr;
	}


	public String getHiredate() {
		return hiredate;
	}


	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}


	public String getSal() {
		return sal;
	}


	public void setSal(String sal) {
		this.sal = sal;
	}


	public String getComm() {
		return comm;
	}


	public void setComm(String comm) {
		this.comm = comm;
	}


	public String getDeptno() {
		return deptno;
	}


	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
	

	
	

}
