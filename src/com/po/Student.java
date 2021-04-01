package com.po;

public class Student {
	private String sno;
	private String sname;
	private String sex;
	private Integer age;
	private String sdept;
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSdept() {
		return sdept;
	}
	public void setSdept(String sdept) {
		this.sdept = sdept;
	}
	public Student(String sno, String sname, String sex, Integer age, String sdept) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sex = sex;
		this.age = age;
		this.sdept = sdept;
	}
	public Student() {
		super();
	}
	
}
