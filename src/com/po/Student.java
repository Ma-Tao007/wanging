package com.po;

public class Student {
	private String sno;
	private String sname;
	private String sex;
	private Integer age;
	private String sdept;
	private String password;
	private String warning;

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
	public Student(String sno, String sname, String sex, Integer age, String sdept,String password) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sex = sex;
		this.age = age;
		this.sdept = sdept;
		this.password = password;
	}
	public Student() {
		super();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getWarning() {
		return warning;
	}

	public void setWarning(String warning) {
		this.warning = warning;
	}
}
