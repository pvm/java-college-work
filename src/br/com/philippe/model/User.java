package br.com.philippe.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by phil on 27/05/17.
 */
public class User {

    public int id;
    public String name;
    public String email;
    public String password;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFromResultSet(ResultSet rs) throws SQLException {
        this.id = rs.getInt("id");
        this.name = rs.getString("name");
        this.email = rs.getString("email");
        this.password = rs.getString("password");
    }

    public String toString() {
        return "[User ID: " + this.id + "]";
    }
}
