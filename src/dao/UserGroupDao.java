package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DbUtil;
import model.Exercise;
import model.UserGroup;

public class UserGroupDao {

	public static boolean saveToDB(UserGroup group) {
		try (Connection conn = DbUtil.getConn()) {

			String sql = "INSERT INTO user_group(name) VALUES (?)";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, group.getUserGroupName());
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean updateAllUserGroupParameter(int id, String name) {
		try (Connection conn = DbUtil.getConn()) {

			String sql = "UPDATE user_group	SET	name=? where id = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, name);
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
			PreparedStatement preparedStatement = conn.prepareStatement("DELETE	FROM user_group WHERE	id=	?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			id = 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static UserGroup loadById(int id) {
		UserGroup group = null;
		try (Connection conn = DbUtil.getConn()) {

			String sql = "SELECT * FROM user_group WHERE id=?;";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				String userGroupName = rs.getString("name");
				group = new UserGroup(id, userGroupName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return group;
	}

	public static List<UserGroup> loadAll() {
		List<UserGroup> result = new ArrayList<>();
		try (Connection conn = DbUtil.getConn()) {
			PreparedStatement stmt = conn.prepareStatement("select id, name " + "from user_group");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				result.add(new UserGroup(rs.getInt("id"), rs.getString("name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
