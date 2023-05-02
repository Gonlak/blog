package dal.jdbc;

import bo.User;
import config.ConnectionProvider;
import dal.UserDao;

import java.sql.*;

public class UserDaoImpl implements UserDao {

    private static final String INSERT_USER = "INSERT INTO users" + "(username," + "email," + "password," + "firstname," + "lastname," + "dateCreated)" + "VALUES(?,?,?,?,?,?)";
    private static final String SELECT_BY_USERNAME = "SELECT * FROM users WHERE username = ?";

    @Override
    public void insert(User user) {
        try (Connection connection = ConnectionProvider.getConnection()) {
            PreparedStatement pStmt = connection.prepareStatement(INSERT_USER);
            pStmt.setString(1, user.getUsername());
            pStmt.setString(2, user.getEmail());
            pStmt.setString(3, user.getPassword());
            pStmt.setString(4, user.getFirstname());
            pStmt.setString(5, user.getLastname());
            pStmt.setDate(6, Date.valueOf(user.getDateCreated()));
            pStmt.executeUpdate();

        } catch (SQLException e) { // DalException
            throw new RuntimeException(e);
        }
    }

    @Override
    public User selectByUsername(String username) {
        try (Connection connection = ConnectionProvider.getConnection()) {
            PreparedStatement pStmt = connection.prepareStatement(SELECT_BY_USERNAME);
            pStmt.setString(1, username);
            ResultSet rs = pStmt.executeQuery();
            if (rs.next())
                return new User(rs.getInt("id"), rs.getString("username"),
                        rs.getString("email"), rs.getString("password"),
                        rs.getString("firstname"),rs.getString("lastname"),
                        rs.getDate("dateCreated").toLocalDate());
        } catch (SQLException e) {//DalException
            e.printStackTrace();
        }
        return null;
    }
}
