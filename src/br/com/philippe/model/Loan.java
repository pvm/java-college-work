package br.com.philippe.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by phil on 26/05/17.
 */
public class Loan {

    private int id;
    private int status;
    private String loanStartDate;
    private String loanEndDate;
    private Book book;
    private Student student;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLoanStartDate() {
        return loanStartDate;
    }

    public void setLoanStartDate(String loanStartDate) {
        this.loanStartDate = loanStartDate;
    }

    public String getLoanEndDate() {
        return loanEndDate;
    }

    public void setLoanEndDate(String loanEndDate) {
        this.loanEndDate = loanEndDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setFromResultSet(ResultSet rs) throws SQLException {
        this.id = rs.getInt("id");
        this.status = rs.getInt("status");
        this.loanStartDate = rs.getString("loan_start_date");
        this.loanEndDate = rs.getString("loan_end_date");
    }

    public String toString() {
        return "[Loan ID: " + this.id + "]";
    }
}
