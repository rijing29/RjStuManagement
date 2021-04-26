package com.whj.stumanagement.rj_stumanagement_back.entity;

public class Stu {
    public Stu() {
    }

    public Stu(Integer sno, String sname, Integer sage, String saddress, String spwd) {
        this.sno = sno;
        this.sname = sname;
        this.sage = sage;
        this.saddress = saddress;
        this.spwd = spwd;
    }

    private Integer sno;
    private String sname;
    private Integer sage;
    private String saddress;
    private String spwd;
    public Integer getSno() {
        return sno;
    }
    public void setSno(Integer sno) {
        this.sno = sno;
    }
    public String getSname() {
        return sname;
    }
    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }
    public Integer getSage() {
        return sage;
    }
    public void setSage(Integer sage) {
        this.sage = sage;
    }
    public String getSaddress() {
        return saddress;
    }
    public void setSaddress(String saddress) {
        this.saddress = saddress == null ? null : saddress.trim();
    }
    public String getSpwd() {
        return spwd;
    }
    public void setSpwd(String spwd) {
        this.spwd = spwd == null ? null : spwd.trim();
    }
    public String toString() {
        return "Stu{" +
                "sno=" + sno +
                ", sname='" + sname + '\'' +
                ", sage=" + sage +
                ", saddress='" + saddress + '\'' +
                ", spwd='" + spwd + '\'' +
                '}';
    }
}