package com.example.HELPING_HANDS;

public class SignUpdb {
    private String name;
    private String email;
    private String pnum;
    private String uname;
    private String pwd;

    public SignUpdb() {
    }

    public SignUpdb(String name, String email, String pnum, String uname, String pwd) {
        this.name = name;
        this.email = email;
        this.pnum = pnum;
        this.uname = uname;
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPnum() {
        return pnum;
    }

    public void setPnum(String pnum) {
        this.pnum = pnum;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
