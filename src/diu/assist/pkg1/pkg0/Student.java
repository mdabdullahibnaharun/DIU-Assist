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
public class Student {
    private int slno;
    private String id;
    private String batch;
    private String name;
    private String mobile;
    private String email;
    private String section;
    private String department;

    public Student() {
    }

    public Student(int slno, String id, String batch, String name, String mobile, String email, String section, String department) {
        this.slno = slno;
        this.id = id;
        this.batch = batch;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.section = section;
        this.department = department;
    }

    public int getSlno() {
        return slno;
    }

    public void setSlno(int slno) {
        this.slno = slno;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "SL No. : " + slno + ",Id :" + id + ", Batch : " + batch + ", Name : " + name + ", Mobile : " + mobile + ", Email : " + email + ", Section : " + section + ", Department : " + department;
    }

    
}
