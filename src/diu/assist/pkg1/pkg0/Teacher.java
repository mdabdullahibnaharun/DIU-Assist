/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diu.assist.pkg1.pkg0;

/**
 *
 * @author Dell
 */
public class Teacher {
    
    private int tslno;
    private String tid;
    private String tteacherinitial;
    private String tname;
    private String tmobile;
    private String temail;
    private String tcoursecode;
    private String tcoursename;
    private String tdepartment;
    private String tfaculty;


    public Teacher() {
    }

    public Teacher(int tslno, String tid, String tteacherinitial, String tname, String tmobile, String temail, String tcoursecode, String tcoursename, String tdepartment, String tfaculty) {
        this.tslno = tslno;
        this.tid = tid;
        this.tteacherinitial = tteacherinitial;
        this.tname = tname;
        this.tmobile = tmobile;
        this.temail = temail;
        this.tcoursecode = tcoursecode;
        this.tcoursename = tcoursename;
        this.tdepartment = tdepartment;
        this.tfaculty = tfaculty;
    }

    public int getTslno() {
        return tslno;
    }

    public void setTslno(int tslno) {
        this.tslno = tslno;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTteacherinitial() {
        return tteacherinitial;
    }

    public void setTteacherinitial(String tteacherinitial) {
        this.tteacherinitial = tteacherinitial;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTmobile() {
        return tmobile;
    }

    public void setTmobile(String tmobile) {
        this.tmobile = tmobile;
    }

    public String getTemail() {
        return temail;
    }

    public void setTemail(String temail) {
        this.temail = temail;
    }

    public String getTcoursecode() {
        return tcoursecode;
    }

    public void setTcoursecode(String tcoursecode) {
        this.tcoursecode = tcoursecode;
    }

    public String getTcoursename() {
        return tcoursename;
    }

    public void setTcoursename(String tcoursename) {
        this.tcoursename = tcoursename;
    }

    public String getTdepartment() {
        return tdepartment;
    }

    public void setTdepartment(String tdepartment) {
        this.tdepartment = tdepartment;
    }

    public String getTfaculty() {
        return tfaculty;
    }

    public void setTfaculty(String tfaculty) {
        this.tfaculty = tfaculty;
    }

    @Override
    public String toString() {
        return "SL No. : " + tslno + ", Id: " + tid + ", TI : " + tteacherinitial + ", Name : " + tname + ", Email : " + temail + ", Coursecode : " + tcoursecode + ", Dept. :" + tdepartment + ", Faculty : " + tfaculty ;
    }

     
}
