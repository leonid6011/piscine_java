package school21.spring.service.repositories;

import school21.spring.service.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository {
    private final DataSource dataSource;

    public UsersRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public User findById(Long id) throws SQLException {
        User user = null;
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {

            String querysql = "SELECT * FROM users WHERE id = " + id;
            ResultSet resultSet = statement.executeQuery(querysql);
            resultSet.next();

            user = new User(resultSet.getInt("id"), resultSet.getString("email"));
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> findAll() throws SQLException {
        List<User> userList = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            String querysql = "SELECT * FROM users;";
            ResultSet resultSet = statement.executeQuery(querysql);

            while (resultSet.next()) {
                userList.add(new User(resultSet.getInt("id"), resultSet.getString("email")));
            };
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void save(User entity) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            String querysql = "INSERT INTO users(email) VALUES (?);";
            PreparedStatement preparedStatement = connection.prepareStatement(querysql);
            preparedStatement.setString(1, entity.getEmail());
            preparedStatement.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(User entity) throws SQLException {
        String query = "UPDATE users SET email = ? WHERE id = ?;";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, entity.getEmail());
            preparedStatement.setLong(2, entity.getId());
            preparedStatement.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

@Override
    public void delete(Long id) {
    String sql = "DELETE FROM users WHERE id=?;";
        try (PreparedStatement pst = dataSource.getConnection().prepareStatement(sql)) {
            pst.setLong(1, id);
            pst.executeQuery();

        } catch (SQLException e) {}
}
    @Override
    public Optional<User> findByEmail(String email) throws SQLException {
        User user = null;
        String sql = "SELECT * FROM users WHERE email=?";
        try (PreparedStatement statement = dataSource.getConnection().prepareStatement(sql)) {

            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if (!resultSet.next()) {
                return Optional.empty();
            }

            user = new User(1L, "");
            user.setId(resultSet.getLong("id"));
            user.setEmail(resultSet.getString("email"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.of(user);
    }
}