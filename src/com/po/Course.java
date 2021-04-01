package com.po;

public class Course {
	private String cno;
	private String cname;
	private String cpno;
	private String ccredit;
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCpno() {
		return cpno;
	}
	public void setCpno(String cpno) {
		this.cpno = cpno;
	}
	public String getCcredit() {
		return ccredit;
	}
	public void setCcredit(String ccredit) {
		this.ccredit = ccredit;
	}
	public Course(String cno, String cname, String cpno, String ccredit) {
		super();
		this.cno = cno;
		this.cname = cname;
		this.cpno = cpno;
		this.ccredit = ccredit;
	}
	public Course() {
		super();
	}
	
}