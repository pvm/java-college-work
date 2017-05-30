package br.com.philippe.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import br.com.philippe.helper.ConnectionHelper;
import br.com.philippe.model.Book;

/**
 * Created by phil on 25/05/17.
 */
public class BookDAO {

    private Connection connection = null;

    public BookDAO() {
        connection = ConnectionHelper.getConnection();
    }

    public void add(Book book) {
        try {
            String query = "INSERT INTO books (name, author, edition, page_number) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, book.getName());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getEdition());
            ps.setInt(4, book.getPageNumber());
            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM books WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Book book) {
        try {
            String query = "UPDATE books SET name = ?, author = ?, edition = ?, page_number = ? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, book.getName());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getEdition());
            ps.setInt(4, book.getPageNumber());
            ps.setInt(5, book.getId());
            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Book> getAll() {

        List<Book> books = new ArrayList<Book>();

        try {
            Statement st = this.connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM books");

            while (rs.next()) {
                Book book = new Book();
                book.setFromResultSet(rs);
                books.add(book);
            }

            st.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    public Book getById(int id) {

        Book book = new Book();

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM books WHERE id = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                book.setFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return book;
    }


    public List<Book> getAvailables() {

        List<Book> books = new ArrayList<Book>();

        try {
            String subquery = "SELECT book_id FROM students_lends_books WHERE status = 0";
            String query = "SELECT * FROM books WHERE id NOT IN (" + subquery + ")";

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Book book = new Book();
                book.setFromResultSet(rs);
                books.add(book);
            }

            st.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }
}