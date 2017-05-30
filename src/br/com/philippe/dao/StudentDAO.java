package br.com.philippe.dao;

import br.com.philippe.helper.ConnectionHelper;
import br.com.philippe.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by phil on 25/05/17.
 */
public class StudentDAO {
    private Connection connection = null;

    public StudentDAO() {
        connection = ConnectionHelper.getConnection();
    }

    public void add(Student student) {
        try {
            String query = "INSERT INTO students (name, ra, course, phone) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, student.getName());
            ps.setString(2, student.getRa());
            ps.setString(3, student.getCourse());
            ps.setString(4, student.getPhone());
            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM students WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Student student) {
        try {
            String query = "UPDATE students SET name = ?, ra = ?, course = ?, phone = ? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, student.getName());
            ps.setString(2, student.getRa());
            ps.setString(3, student.getCourse());
            ps.setString(4, student.getPhone());
            ps.setInt(5, student.getId());
            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAll() {

        List<Student> students = new ArrayList<Student>();

        try {
            Statement st = this.connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                Student student = new Student();
                student.setFromResultSet(rs);
                students.add(student);
            }

            st.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    public Student getById(int id) {

        Student student = new Student();

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM students WHERE id = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                student.setFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }
}
