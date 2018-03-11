package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DbUtil;
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
				result.add(new User(rs.getInt("id"), rs.getString("username"), rs.getString("mail"),
						rs.getString("password"), rs.getInt("user_group_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
