package br.com.philippe.dao;

import br.com.philippe.helper.ConnectionHelper;
import br.com.philippe.model.Book;
import br.com.philippe.model.Loan;
import br.com.philippe.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by phil on 26/05/17.
 */
public class LoanDAO {
    
    Connection connection = null;
    
    public LoanDAO() {
        connection = ConnectionHelper.getConnection();
    }

    public void setAsReturned(int id) {

        PreparedStatement statement = null;

        try {
            connection = ConnectionHelper.getConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE students_lends_books SET status = 1 WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add(Loan loan) {
        try {
            String query = "INSERT INTO students_lends_books (status, loan_start_date, loan_end_date, book_id, student_id) VALUES (0, ?, ?, ?, ?);";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, loan.getLoanStartDate());
            ps.setString(2, loan.getLoanEndDate());
            ps.setInt(3, loan.getBook().getId());
            ps.setInt(4, loan.getStudent().getId());
            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Loan> getAll() {

        List<Loan> loans = new ArrayList<Loan>();

        try {
            Statement st = this.connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students_lends_books");

            while (rs.next()) {
                Loan loan = new Loan();

                // Define o objeto do livro
                Book book = (new BookDAO()).getById(rs.getInt("book_id"));
                loan.setBook(book);

                // Define o objeto do estudante
                Student student = (new StudentDAO()).getById(rs.getInt("student_id"));
                loan.setStudent(student);

                loan.setFromResultSet(rs);
                loans.add(loan);
            }

            st.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return loans;
    }


}
