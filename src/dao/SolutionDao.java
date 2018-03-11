package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import db.DbUtil;
import model.Solution;

public class SolutionDao {

	public static List<Solution> loadAll(Integer limit) {
		List<Solution> result = new ArrayList<>();
		try (Connection conn = DbUtil.getConn()) {
			PreparedStatement stmt = conn
					.prepareStatement("select id, created, updated, description, exercise_id, users_id "
							+ "from solutions order by created desc limit ?");
			stmt.setInt(1, limit);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				result.add(new Solution(rs.getInt("id"), rs.getDate("created"), rs.getDate("updated"),
						rs.getString("description"), rs.getInt("exercise_id"), rs.getInt("users_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static Solution loadById(int solutionId) {
		try (Connection conn = DbUtil.getConn()) {
			PreparedStatement stmt = conn.prepareStatement(
					"select id, created, updated, description, exercise_id, users_id " + "from solutions where id =?");
			stmt.setInt(1, solutionId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				return new Solution(rs.getInt("id"), rs.getDate("created"), rs.getDate("updated"),
						rs.getString("description"), rs.getInt("exercise_id"), rs.getInt("users_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}