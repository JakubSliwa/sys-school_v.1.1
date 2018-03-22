package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DbUtil;
import model.User;

public class ExerciseDao {

	public static List<User> loadAll() {
		List<User> allUsers = null;

		try (Connection conn = DbUtil.getConn()) {
			String sql = "SELECT * FROM users";
			ResultSet rs = conn.createStatement().executeQuery(sql);
			allUsers = new ArrayList<>();

			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String email = rs.getString("email");
				int userGroupId = rs.getInt("user_group_id");

				allUsers.add(new User(username, password, email, userGroupId));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allUsers;
	}

	public static User loadById(int id) {
		User user = null;
		try (Connection conn = DbUtil.getConn()) {

			String sql = "SELECT * FROM users WHERE id=?;";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String email = rs.getString("email");
				int userGroupId = rs.getInt("user_group_id");

				user = new User(username, password, email, userGroupId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public static List<User> loadAllByGroupId(Integer groupId) {
		List<User> result = new ArrayList<>();
		try (Connection conn = DbUtil.getConn()) {
			PreparedStatement preparedStatement = conn.prepareStatement(
					"select id, username, mail, password, user_group_id " + "from users where user_group_id = ?");
			preparedStatement.setInt(1, groupId);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				result.add(new User(rs.getString("username"), rs.getString("mail"), rs.getString("password"),
						rs.getInt("user_group_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static boolean saveToDB(User user) {
		try (Connection conn = DbUtil.getConn()) {

			String sql = "INSERT INTO users(username,email,password, user_group_id) VALUES (?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setInt(4, user.getUserGroupId());
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean updateAllUserParameters(int id, String newName, String newEmail, String newPassword) {
		try (Connection conn = DbUtil.getConn()) {

			String sql = "UPDATE users SET	username=?,	email=?, password=? where id = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, newName);
			preparedStatement.setString(2, newEmail);
			preparedStatement.setString(3, newPassword);
			preparedStatement.setInt(4, id);
			preparedStatement.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean updateNameAndEmail(int id, String newName, String newEmail) {
		try (Connection conn = DbUtil.getConn()) {

			String sql = "UPDATE users SET	username=?,	email=? where id = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, newName);
			preparedStatement.setString(2, newEmail);
			preparedStatement.setInt(3, id);
			preparedStatement.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean updateName(int id, String newName) {
		try (Connection conn = DbUtil.getConn()) {

			String sql = "UPDATE users SET	username=? where id = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, newName);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean updateEmail(int id, String newEmail) {
		try (Connection conn = DbUtil.getConn()) {

			String sql = "UPDATE users SET	email=? where id = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, newEmail);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean updatePassword(int id, String newPassword) {
		try (Connection conn = DbUtil.getConn()) {

			String sql = "UPDATE users SET	password=? where id = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, newPassword);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void delete(int id) {
		try (Connection conn = DbUtil.getConn()) {
			PreparedStatement preparedStatement = conn.prepareStatement("DELETE	FROM	users	WHERE	id=	?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			id = 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
