package br.com.philippe.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by phil on 25/05/17.
 */
public class Book {

    private int id;
    private String name;
    private String edition;
    private String author;
    private int pageNumber;

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

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setFromResultSet(ResultSet rs) throws SQLException{
        this.name = rs.getString("name");
        this.id = rs.getInt("id");
        this.author = rs.getString("author");
        this.edition = rs.getString("edition");
        this.pageNumber = rs.getInt("page_number");
    }

    public String toString() {
        return "[Book ID: " + this.id + "]";
    }
}
