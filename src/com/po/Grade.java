package com.po;

/**
 * @anther mt
 * @creater 2021-04-09 11:12
 */
public class Grade {
    private Integer id;
    private String sno;//学号
    private String sname;//姓名
    private String cname;//课程名
    private Integer credit;//学分
    private Integer grade;//学生成绩

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }


    public Grade() {
        super();
    }

    public Grade(Integer id, String sno, String sname, String cname, Integer credit, Integer grade) {
        this.id = id;
        this.sno = sno;
        this.sname = sname;
        this.cname = cname;
        this.credit = credit;
        this.grade = grade;
    }
}
