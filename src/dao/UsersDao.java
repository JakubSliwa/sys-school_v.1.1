package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DbUtil;
import entity.Users;
import jdbc.DbConnection;
import model.User;

public class UsersDao {

	public static List<User> loadAllByGroupId(Integer groupId) {
		List<User> result = new ArrayList<>();
		try (Connection conn = DbUtil.getConn()) {
			PreparedStatement stmt = conn.prepareStatement(
					"select id, username, mail, password, user_group_id " + "from users where user_group_id = ?");
			stmt.setInt(1, groupId);
			ResultSet rs = stmt.executeQuery();
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
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setInt(4, user.getUserGroupId());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean update(int id, String newName) {
		try (Connection conn = DbUtil.getConn()) {

			String sql = "UPDATE users SET	username=?,	email=?, password=? where id = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, this.username);
			preparedStatement.setString(2, this.email);
			preparedStatement.setString(3, this.password);
			preparedStatement.setInt(4, this.id);
			preparedStatement.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void delete(int id) {
		try (Connection conn = DbUtil.getConn()) {
			PreparedStatement stmt = conn.prepareStatement("DELETE	FROM	users	WHERE	id=	?");
			stmt.setInt(1, id);
			stmt.executeUpdate();
			id = 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
