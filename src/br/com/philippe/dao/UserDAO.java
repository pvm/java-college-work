package br.com.philippe.dao;

import br.com.philippe.helper.ConnectionHelper;
import br.com.philippe.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by phil on 20/05/17.
 */
public class UserDAO {

    private User user = null;

    public void setAsReturned(int id) {

    }

    public boolean isValid(String email, String password) {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        Boolean status = false;

        try {
            connection = ConnectionHelper.getConnection();
            statement = connection.prepareStatement("SELECT * FROM users WHERE email=? AND password=?");

            statement.setString(1, email);
            statement.setString(2, password);

            rs = statement.executeQuery();
            status = rs.next();

            if (status) {
                user = new User();
                user.setFromResultSet(rs);
            }

            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status;
    }

    public User getUser() {
        return user;
    }
}
