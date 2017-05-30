package br.com.philippe.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by phil on 25/05/17.
 */
public class Student {

    private int id;
    private String name;
    private String ra;
    private String course;
    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setFromResultSet(ResultSet rs) throws SQLException {
        this.id = rs.getInt("id");
        this.name = rs.getString("name");
        this.ra = rs.getString("ra");
        this.course = rs.getString("course");
        this.phone = rs.getString("phone");
    }

    public String toString() {
        return "[Student ID: " + this.id + "]";
    }
}
